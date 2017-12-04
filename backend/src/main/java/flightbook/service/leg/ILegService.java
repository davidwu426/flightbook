package flightbook.service.leg;

import flightbook.Role;
import flightbook.entity.leg.Leg;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ILegService {
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
	 * Get a specific leg of a flight
	 * @param airlineId AirlineId of airline to get leg of
	 * @param flightNo  Flight number of flight to get leg of
	 * @param legNo     Leg number of leg to get
	 * @return  Leg of a flight
	 */
	Leg getLeg(String airlineId, int flightNo, int legNo);

	/**
	 * Inserts a flight leg
	 *
	 * @param leg  Leg to insert
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void insertLeg(Leg leg);

	/**
	 * Updates a leg, excluding airlineId, flightNo, and legNo
	 *
	 * @param leg   Leg to update
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void updateLeg(Leg leg);

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
