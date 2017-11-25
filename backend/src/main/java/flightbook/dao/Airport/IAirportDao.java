package flightbook.dao.Airport;

import flightbook.entity.airport.Airport;

import java.util.List;

public interface IAirportDao {
	List<Airport> getAllAirports();

	Airport getAirportById(String id);

	void insertAirport(Airport airport);

	void deleteAirport(String id);
}
