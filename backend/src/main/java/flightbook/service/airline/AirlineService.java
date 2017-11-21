package flightbook.service.airline;

import flightbook.dao.airline.IAirlineDao;
import flightbook.entity.airline.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirlineService {
	@Autowired
	private IAirlineDao airlineDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Airline> getAllAirlines() {
		return airlineDao.getAllAirlines();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Airline getAirlineById(String id) {
		return airlineDao.getAirlineById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertAirline(Airline airline) {
		airlineDao.insertAirline(airline);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateAirline(Airline airline) {
		airlineDao.updateAirline(airline);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAirline(String id) {
		airlineDao.deleteAirline(id);
	}
}
