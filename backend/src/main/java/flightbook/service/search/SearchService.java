package flightbook.service.search;


import flightbook.dao.airline.IAirlineDao;
import flightbook.dao.fare.IFareDao;
import flightbook.dao.flight.IFlightDao;
import flightbook.dao.leg.ILegDao;
import flightbook.entity.fare.FareType;
import flightbook.entity.flight.Flight;
import flightbook.entity.leg.Leg;
import flightbook.entity.leg.TripLeg;
import flightbook.entity.search.SearchCriteria;
import flightbook.entity.search.SearchEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SearchService implements ISearchService {
    @Autowired
	IFlightDao flightDao;
    @Autowired
	ILegDao legDao;
    @Autowired
    IFareDao fareDao;
    @Autowired
	IAirlineDao airlineDao;

    @Override
    public List<SearchEntry> getOneWayResults(String depAirport, String arrAirport, String depDate, String flightClass) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(Long.parseLong(depDate)));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        StringBuilder binary = new StringBuilder("0000000");
        binary.setCharAt(dayOfWeek - 1,'1');

        // list of flights that leave from depAirport operating on depTime
        List<Flight> flights = flightDao.getFlightsDepartingFromAirportOnDayOfWeek(depAirport, binary.toString());

        List<SearchEntry> searchEntries = new ArrayList<>();

        // find flights from eligible flights that stop at arrAirport
	    for (Flight f : flights) {
	    	// legs on flight
	    	List<TripLeg> tripLegs = new ArrayList<>();

	    	// legs of flight
	    	List<Leg> flightLegs = legDao.getLegsByFlight(f.getAirlineId(), f.getFlightNo());

	    	int fromStopNo = -1;
	    	for (int i = 0; i < flightLegs.size(); i++) {
			    SearchEntry searchEntry = new SearchEntry();

			    Leg l = flightLegs.get(i);

	    		// start airport is reached
	    		if (l.getDepAirportId().equals(depAirport)) {
	    			fromStopNo = i + 1;
			    }

			    // start adding legs
			    if (fromStopNo > 0) {
	    			TripLeg tripLeg = new TripLeg();
	    			tripLeg.setLeg(l);
	    			tripLeg.setLayoverTime(l.getDepTime().getTime() - l.getArrTime().getTime());

	    			// last leg of flight
				    if (i == flightLegs.size() - 1) {
						Leg firstLeg = flightLegs.get(0);
						int departureTime = (int) (l.getDepTime().getTime() % (24 * 60 * 60 * 1000L));
						int arrivalTime = (int) (firstLeg.getArrTime().getTime() % (24 * 60 * 60 * 1000L));
						long diff = arrivalTime - departureTime;

						// add a day
						if (diff < 0) {
							diff += 24 * 60 * 60 * 1000L;
						}
						tripLeg.setFlightDuration(diff);
				    } else {
	    			    tripLeg.setFlightDuration(flightLegs.get(i + 1).getArrTime().getTime() - l.getDepTime().getTime());
				    }

				    tripLegs.add(tripLeg);

				    // destination reached
				    if (l.getArrAirportId().equals(arrAirport)) {
					    // get price of flight
					    double price = fareDao.getFare(f.getAirlineId(), f.getFlightNo(), FareType.REGULAR, flightClass);
					    String airlineName = airlineDao.getAirlineById(f.getAirlineId()).getName();

	                    searchEntry.setAirlineId(f.getAirlineId());
	                    searchEntry.setAirlineName(airlineName);
	                    searchEntry.setPrice(price);
	                    searchEntry.setFromFlightNo(fromStopNo);
	                    searchEntry.setTripLegs(tripLegs);
	                    searchEntry.setFlightClass(flightClass);

	                    Date flightDepTime = tripLegs.get(0).getLeg().getDepTime();
	                    Date flightArrTime;
	                    if (i == flightLegs.size() - 1) {
	                    	flightArrTime = flightLegs.get(0).getArrTime();
	                    	while (flightArrTime.getTime() < flightDepTime.getTime()) {
	                    		Calendar cal = Calendar.getInstance();
	                    		cal.setTime(flightArrTime);
	                    		cal.add(Calendar.DAY_OF_YEAR, 1);
	                    		flightArrTime = cal.getTime();
		                    }
	                    } else {
	                    	flightArrTime = flightLegs.get(i + 1).getArrTime();
	                    }

	                    Calendar calendar = Calendar.getInstance();
	                    calendar.setTimeInMillis(Long.parseLong(depDate));
	                    Date d = calendar.getTime();

					    searchEntry.setTripDepTime(updateDate(flightDepTime, d, 0));
					    searchEntry.setTripArrTime(updateDate(flightArrTime, d, getDayOffset(flightDepTime, flightArrTime)));
					    searchEntries.add(searchEntry);

					    break;
				    }
			    }
		    }
	    }

	    return searchEntries;
    }

	@Override
	public List<List<SearchEntry>> getRoundTripResults(String depAirport, String arrAirport, String depDate, String retDate, String flightClass) {
		List<SearchEntry> tripsThere = getOneWayResults(depAirport, arrAirport, depDate, flightClass);
		List<SearchEntry> tripsBack = getOneWayResults(arrAirport, depAirport, retDate, flightClass);

		List<List<SearchEntry>> roundTrips = new ArrayList<>();
		// get all combinations of trips there and back
		for (SearchEntry tt : tripsThere) {
			for (SearchEntry tb : tripsBack) {
				List<SearchEntry> roundTrip = new ArrayList<>();
				roundTrip.add(tt);
				roundTrip.add(tb);

				roundTrips.add(roundTrip);
			}
		}

		return roundTrips;
	}

	@Override
	public List<List<SearchEntry>> getMultiCityTripResults(List<SearchCriteria> searchCriteria, String flightClass) {
    	List<List<SearchEntry>> tripsForEachLeg = new ArrayList<>();

		for (SearchCriteria sc : searchCriteria) {
			List<SearchEntry> trips = getOneWayResults(sc.getFromAirport(), sc.getToAirport(),
					sc.getDepartureDate().getTime() + "", flightClass);

			// no flights for this city
			if (trips.size() == 0) {
				return new ArrayList<>();
			}

			tripsForEachLeg.add(trips);
		}

		// get all combinations of flights
		List<List<SearchEntry>> results = getTripCombinations(tripsForEachLeg.get(0), tripsForEachLeg.subList(1, tripsForEachLeg.size()));

		return results;
	}

	private List<List<SearchEntry>> getTripCombinations(List<SearchEntry> firstLeg, List<List<SearchEntry>> nextLegs) {
    	List<List<SearchEntry>> combinations = new ArrayList<>();

    	for (SearchEntry s : firstLeg) {
		    List<SearchEntry> combination = new ArrayList<>();
		    combination.add(s);

		    if (nextLegs.size() == 0) {
			    for (List<SearchEntry> lastLegs : nextLegs) {
				    combination.addAll(lastLegs);
			    }
		    } else {
			    List<List<SearchEntry>> recursiveLegs = getTripCombinations(nextLegs.get(0), nextLegs.subList(1, nextLegs.size()));
			    for (List<SearchEntry> otherLegs : recursiveLegs) {
				    combination.addAll(otherLegs);
			    }
		    }

		    combinations.add(combination);
	    }

	    return combinations;
	}

	/**
	 * Returns the difference in number of days between two dates
	 *
	 * @param date1 Earlier date
	 * @param date2 Later date
	 * @return  Number of days difference
	 */
	private int getDayOffset(Date date1, Date date2) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date2);
    	int day2 = calendar.get(Calendar.DAY_OF_YEAR);
    	calendar.setTime(date1);

    	return Math.abs(day2 - calendar.get(Calendar.DAY_OF_YEAR));
    }

	/**
	 * Updates a date's month, day, and year to match dateToUpdateTo
	 *
	 * @param dateToBeUpdated   Date whose D, M, Y should be updated
	 * @param dateToUpdateTo    Date with D, M, Y to update to
	 * @param dayOffset         Days to offset result date by
	 * @return  Updated dateToBeUpdated
	 */
	private Date updateDate(Date dateToBeUpdated, Date dateToUpdateTo, int dayOffset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateToUpdateTo);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(dateToBeUpdated);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day + dayOffset);

		return calendar.getTime();
	}
}
