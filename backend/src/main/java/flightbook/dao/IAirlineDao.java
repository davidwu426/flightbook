package flightbook.dao;

import flightbook.model.Airline;

import java.util.List;

public interface IAirlineDao {
	/**
	 * Get all airlines
	 */
	public List<Airline> getAllAirlines();

	/**
	 * Find airline given ID of airline
	 * @param id    ID of airline
	 */
	public Airline getAirlineById(String id);

	/**
	 * Inserts and airline
	 * @param airline   Airline to insert
	 */
    public void insert(Airline airline);
}
