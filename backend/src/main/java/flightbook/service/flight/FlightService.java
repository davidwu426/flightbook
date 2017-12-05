package flightbook.service.flight;

import flightbook.dao.flight.IFlightDao;
import flightbook.dao.leg.ILegDao;
import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.leg.Leg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {
	@Autowired
	IFlightDao flightDao;
	@Autowired
	ILegDao legDao;

	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Override
	public List<Flight> getFlightsByAirline(String airlineId) {
		return flightDao.getFlightsByAirline(airlineId);
	}

	@Override
	public List<Leg> getLegsByAirline(String airlineId) {
		return legDao.getLegsByAirline(airlineId);
	}

	@Override
	public List<Leg> getLegsByFlight(String airlineId, int flightNo) {
		return legDao.getLegsByFlight(airlineId, flightNo);
	}

	@Override
	public List<CustomerOnFlight> getCustomerOnFlight(String airlineId, int flightNo) {
		return flightDao.getCustomerOnFlight(airlineId, flightNo);
	}

	@Override
	public List<FrequentFlight> getFrequentFlight()
	{
		return flightDao.getFrequentFlight();
	}

	@Override
	public List<Flight> getDelayedFlights() {
		return flightDao.getDelayedFlights();
	}

	@Override
	public Leg getLeg(String airlineId, int flightNo, int legNo) {
		return legDao.getLeg(airlineId, flightNo, legNo);
	}

	@Override
	public Flight getFlight(String airlineId, int flightNo) {
		return flightDao.getFlight(airlineId, flightNo);
	}



	@Override
	public List<Leg> getAllLegs() {
		return legDao.getAllLegs();
	}

	@Override
	public void insertFlight(Flight flight) {
		flightDao.insertFlight(flight);
	}

	@Override
	public void insertLeg(Leg leg) {
		legDao.insertLeg(leg);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
	}

	@Override
	public void updateLeg(Leg leg) {
		legDao.updateLeg(leg);
	}

	@Override
	public void deleteFlight(String airlineId, int flightNo) {
		flightDao.deleteFlight(airlineId, flightNo);
	}

	@Override
	public void deleteLeg(String airlineId, int flightNo, int legNo) {
		legDao.deleteLeg(airlineId, flightNo, legNo);
	}
}
