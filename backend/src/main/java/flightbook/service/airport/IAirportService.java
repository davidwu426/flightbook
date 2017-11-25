package flightbook.service.airport;

import flightbook.Role;
import flightbook.entity.airport.Airport;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IAirportService {
	/**
	 * Get all airports
	 */
	List<Airport> getAllAirports();

	/**
	 * Find airport given ID
	 *
	 * @param id    ID of airport
	 */
	Airport getAirportById(String id);

	/**
	 * Inserts an airport
	 *
	 * @param airport   Airport to insert
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void insertAirport(Airport airport);

	/**
	 * Deletes an airport given an ID
	 *
	 * @param id    ID of airport to delete
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void deleteAirport(String id);
}
