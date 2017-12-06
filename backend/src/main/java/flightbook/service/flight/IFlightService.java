package flightbook.service.flight;

import flightbook.Role;
import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
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
	 * Get all flights from an airport
	 *
	 * @param airportId	Airport to get flights from
	 * @return List of flights from airport
	 */
	List<Flight> getFlightsByAirport(String airportId);

	/**
	 * Find a specific flight
	 *
	 * @param airlineId     Airline ID of flight to get
	 * @param flightNo      Flight number of flight to get
	 * @return  Flight with specified airline ID and flight number
	 */
	Flight getFlight(String airlineId, int flightNo);

	/**
	 *
	 * @return List of 5 most frequent flight
	 */
	List<FrequentFlight> getFrequentFlight();

	/**
	 *
	 * @param airlineId Airline id for the flight
	 * @param flightNo flight number for the flight
	 * @return the list of customers who are on the flight
	 */
	List<CustomerOnFlight> getCustomerOnFlight(String airlineId, int flightNo);

	/**
	 *
	 * @return return the flights that are delayed
	 */
	List<Flight> getDelayedFlights();

	/**
	 *
	 * @return List of flights that are on time
	 */
	List<Flight> getOnTimeFlight();

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
