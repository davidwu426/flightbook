package flightbook.service.flight;

import flightbook.dao.flight.IFlightDao;
import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {
	@Autowired
	IFlightDao flightDao;

	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Override
	public List<Flight> getFlightsByAirline(String airlineId) {
		return flightDao.getFlightsByAirline(airlineId);
	}

	@Override
	public List<Flight> getFlightsByAirport(String airportId) {
		return flightDao.getFlightsByAirport(airportId);
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
	public Flight getFlight(String airlineId, int flightNo) {
		return flightDao.getFlight(airlineId, flightNo);
	}



	@Override
	public void insertFlight(Flight flight) {
		flightDao.insertFlight(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
	}

	@Override
	public void deleteFlight(String airlineId, int flightNo) {
		flightDao.deleteFlight(airlineId, flightNo);
	}
}
