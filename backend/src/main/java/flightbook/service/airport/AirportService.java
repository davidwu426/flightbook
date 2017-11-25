package flightbook.service.airport;

import flightbook.dao.Airport.IAirportDao;
import flightbook.entity.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements IAirportService {
	@Autowired
	IAirportDao airportDao;

	@Override
	public List<Airport> getAllAirports() {
		return airportDao.getAllAirports();
	}

	@Override
	public Airport getAirportById(String id) {
		return airportDao.getAirportById(id);
	}

	@Override
	public void insertAirport(Airport airport) {
		airportDao.insertAirport(airport);
	}

	@Override
	public void deleteAirport(String id) {
		airportDao.deleteAirport(id);
	}
}
