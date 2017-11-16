package flightbook.dao;

import flightbook.model.Airline;

import java.util.List;

public interface IAirlineDao {
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
     void insert(Airline airline);

	/**
	 * Updates an airline with given ID
	 *
	 * @param airline   Airline to update
	 */
	 void update(Airline airline);

	/**
	 * Deletes an airline given an ID
	 *
	 * @param id    ID of airline to delete
	 */
	 void delete(String id);
}