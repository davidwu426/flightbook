package flightbook.service.flight;

import flightbook.Role;
import flightbook.entity.flight.Flight;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IFlightService {
	/**
	 * Get all flights
	 */
	List<Flight> getAllFlights();

	/**
	 * Get all flights from an airline
	 *
	 * @param airlineId     Airline to get flights from
	 * @return  List of flights from airline
	 */
	List<Flight> getFlightsByAirline(String airlineId);

	/**
	 * Find a specific flight
	 *
	 * @param airlineId     Airline ID of flight to get
	 * @param flightNo      Flight number of flight to get
	 * @return  Flight with specified airline ID and flight number
	 */
	Flight getFlight(String airlineId, int flightNo);

	/**
	 * Inserts a flight
	 *
	 * @param flight  Flight to insert
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void insertFlight(Flight flight);

	/**
	 * Updates a flight, excluding airlineId and flightNo
	 *
	 * @param flight    Flight to update
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void updateFlight(Flight flight);

	/**
	 * Deletes a flight given an airline ID and flight number
	 *
	 * @param airlineId     Airline ID
	 * @param flightNo      Flight number
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteFlight(String airlineId, int flightNo);
}
