package flightbook.dao.airline;

import flightbook.entity.airline.Airline;

import java.util.List;

public interface IAirlineDao {
	 List<Airline> getAllAirlines();

	 Airline getAirlineById(String id);

     void insertAirline(Airline airline);

	 void updateAirline(Airline airline);

	 void deleteAirline(String id);
}