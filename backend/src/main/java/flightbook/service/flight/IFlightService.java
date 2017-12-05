package flightbook.service.flight;

import flightbook.Role;
import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.leg.Leg;
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
	 * Get all legs
	 */
	List<Leg> getAllLegs();

	/**
	 * Get all legs of an airline
	 *
	 * @param airlineId AirlineId of airline to get legs of
	 * @return  List of legs of an airline
	 */
	List<Leg> getLegsByAirline(String airlineId);

	/**
	 * Get all legs of a flight by flight number
	 *
	 * @param airlineId AirlineId of airline to get legs of
	 * @param flightNo  Flight number of flight to get legs of
	 * @return  List of legs of a flight by flight number
	 */
	List<Leg> getLegsByFlight(String airlineId, int flightNo);

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
	 * Get a specific leg of a flight
	 * @param airlineId AirlineId of airline to get leg of
	 * @param flightNo  Flight number of flight to get leg of
	 * @param legNo     Leg number of leg to get
	 * @return  Leg of a flight
	 */
	Leg getLeg(String airlineId, int flightNo, int legNo);

	/**
	 * Inserts a flight
	 *
	 * @param flight  Flight to insert
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void insertFlight(Flight flight);

	/**
	 * Inserts a flight leg
	 *
	 * @param leg  Leg to insert
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void insertLeg(Leg leg);

	/**
	 * Updates a flight, excluding airlineId and flightNo
	 *
	 * @param flight    Flight to update
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void updateFlight(Flight flight);

	/**
	 * Updates a leg, excluding airlineId, flightNo, and legNo
	 *
	 * @param leg   Leg to update
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void updateLeg(Leg leg);

	/**
	 * Deletes a flight given an airline ID and flight number
	 *
	 * @param airlineId     Airline ID
	 * @param flightNo      Flight number
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteFlight(String airlineId, int flightNo);

	/**
	 * Delete a leg
	 *
	 * @param airlineId AirlineId of flight to delete
	 * @param flightNo  Flight number of leg to delete
	 * @param legNo     Leg number of leg to delete
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteLeg(String airlineId, int flightNo, int legNo);
}
