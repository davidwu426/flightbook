package flightbook.dao.flight;

import flightbook.entity.flight.Flight;

import java.util.List;

public interface IFlightDao {
	List<Flight> getAllFlights();

	List<Flight> getFlightsByAirline(String airlineId);

	List<Flight> getFlightsDepartingFromAirportOnDayOfWeek(String airportId, String dayOfWeekBinary);

	Flight getFlight(String airlineId, int flightNo);

	void insertFlight(Flight flight);

	void updateFlight(Flight flight);

	void deleteFlight(String airlineId, int flightNo);
}
