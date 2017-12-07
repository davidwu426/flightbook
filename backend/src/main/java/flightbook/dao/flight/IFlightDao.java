package flightbook.dao.flight;

import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.BestSoldFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.customer.Customer;

import java.util.List;

public interface IFlightDao {
	List<Flight> getAllFlights();

	List<Flight> getFlightsByAirline(String airlineId);

	List<Flight> getFlightsDepartingFromAirportOnDayOfWeek(String airportId, String dayOfWeekBinary);
	
	List<Flight> getFlightsByAirport(String airportId);

	Flight getFlight(String airlineId, int flightNo);

	List<FrequentFlight> getFrequentFlight ();

	List<CustomerOnFlight> getCustomerOnFlight(String airlineId, int flightNo);

	List<Flight> getDelayedFlights();

	List<Flight> getOnTimeFlights();

	List<BestSoldFlight> getBestSoldFlights();

	void insertFlight(Flight flight);

	void updateFlight(Flight flight);

	void deleteFlight(String airlineId, int flightNo);

}
