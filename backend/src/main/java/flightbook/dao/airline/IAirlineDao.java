package flightbook.dao.airline;

import flightbook.entity.airline.Airline;

import java.util.List;

public interface IAirlineDao {
	 List<Airline> getAllAirlines();

	 Airline getAirlineById(String id);

     void insert(Airline airline);

	 void update(Airline airline);

	 void delete(String id);
}