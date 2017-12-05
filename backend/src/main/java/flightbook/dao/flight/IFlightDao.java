package flightbook.dao.flight;

import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.customer.Customer;

import java.util.List;

public interface IFlightDao {
	List<Flight> getAllFlights();

	List<Flight> getFlightsByAirline(String airlineId);

	Flight getFlight(String airlineId, int flightNo);

	List<FrequentFlight> getFrequentFlight ();

	List<CustomerOnFlight> getCustomerOnFlight(String airlineId, int flightNo);

	List<Flight> getDelayedFlights();

	void insertFlight(Flight flight);

	void updateFlight(Flight flight);

	void deleteFlight(String airlineId, int flightNo);

}
