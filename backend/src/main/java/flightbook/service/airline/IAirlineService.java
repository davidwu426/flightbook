package flightbook.service.airline;

import flightbook.Role;
import flightbook.entity.airline.Airline;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IAirlineService {
	/**
	 * Get all airlines
	 */
	List<Airline> getAllAirlines();

	/**
	 * Find airline given ID of airline
	 * @param id    ID of airline
	 */
	Airline getAirlineById(String id);

	/**
	 * Inserts and airline
	 * @param airline   Airline to insert
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void insertAirline(Airline airline);

	/**
	 * Updates an airline with given ID
	 *
	 * @param airline   Airline to update
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void updateAirline(Airline airline);

	/**
	 * Deletes an airline given an ID
	 *
	 * @param id    ID of airline to delete
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void deleteAirline(String id);
}
