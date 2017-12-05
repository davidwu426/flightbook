package flightbook.service.search;


import flightbook.dao.fare.IFareDao;
import flightbook.dao.flight.IFlightDao;
import flightbook.dao.leg.ILegDao;
import flightbook.entity.fare.FareType;
import flightbook.entity.flight.Flight;
import flightbook.entity.leg.Leg;
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

    @Override
    public List<SearchEntry> getOneWayResults(String depAirport, String arrAirport, String depTime, String flightClass) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(Long.parseLong(depTime)));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        StringBuilder binary = new StringBuilder("0000000");
        binary.setCharAt(dayOfWeek - 1,'1');

        // list of flights that leave from depAirport operating on depTime
        List<Flight> flights = flightDao.getFlightsDepartingFromAirportOnDayOfWeek(depAirport, binary.toString());

        List<SearchEntry> searchEntries = new ArrayList<>();

        // find flights from eligible flights that stop at arrAirport
	    for (Flight f : flights) {
	    	// legs on flight
	    	List<Leg> trip = new ArrayList<>();

	    	// legs of flight
	    	List<Leg> legs = legDao.getLegsByFlight(f.getAirlineId(), f.getFlightNo());

            // find starting leg number
		    int fromStopNo = 1;
	    	for (Leg l : legs) {
			    if (l.getDepAirportId().equals(depAirport)) {
			    	break;
			    }
			    fromStopNo++;
		    }

		    // add legs until arrAirport is reached or back to start
		    for (int i = 0; i < legs.size(); i++) {
	    		Leg l = legs.get((fromStopNo + i - 1) % legs.size());
	    		trip.add(l);

	    		// arrAirport reached
			    if (l.getArrAirportId().equals(arrAirport)) {
			    	// get price of flight
				    double price = fareDao.getFare(f.getAirlineId(), f.getFlightNo(), FareType.REGULAR, flightClass);

			    	SearchEntry e = new SearchEntry(f.getAirlineId(), price, fromStopNo, trip);
			    	searchEntries.add(e);

			    	break;
			    }
		    }
	    }

	    return searchEntries;
    }
}
