package flightbook.service;

import flightbook.model.Airline;

import java.util.List;

public interface IAirlineService {
	List<Airline> getAllAirlines();

	Airline getAirlineById(String id);

	void insertAirline(Airline airline);

	void updateAirline(Airline airline);

	void deleteAirline(String id);
}
