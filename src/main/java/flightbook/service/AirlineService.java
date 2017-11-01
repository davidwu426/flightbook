package flightbook.service;

import flightbook.dao.IAirlineDao;
import flightbook.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirlineService {
	@Autowired
	private IAirlineDao airlineDao;

	@Override
	public List<Airline> getAllAirlines() {
		return airlineDao.getAllAirlines();
	}

	@Override
	public Airline getAirlineById(String id) {
		return airlineDao.getAirlineById(id);
	}

	@Override
	public void insertAirline(Airline airline) {
		airlineDao.insert(airline);
	}
}
