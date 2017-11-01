package flightbook.dao;

import flightbook.entity.Airline;

public interface IAirlineDao {
	/**
	 * Inserts and airline
	 * @param airline   Airline to insert
	 */
    public void insert(Airline airline);

    /**
     * Find airline given ID of airline
     * @param id    ID of airline
     */
    public Airline getAirlineById(String id);
}
