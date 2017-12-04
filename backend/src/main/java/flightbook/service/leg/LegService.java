package flightbook.service.leg;

import flightbook.dao.leg.ILegDao;
import flightbook.entity.leg.Leg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LegService implements ILegService {
	@Autowired
	ILegDao legDao;

	@Override
	public List<Leg> getLegsByAirline(String airlineId) {
		return legDao.getLegsByAirline(airlineId);
	}

	@Override
	public List<Leg> getLegsByFlight(String airlineId, int flightNo) {
		return legDao.getLegsByFlight(airlineId, flightNo);
	}

	@Override
	public Leg getLeg(String airlineId, int flightNo, int legNo) {
		return legDao.getLeg(airlineId, flightNo, legNo);
	}

	@Override
	public List<Leg> getAllLegs() {
		return legDao.getAllLegs();
	}

	@Override
	public void insertLeg(Leg leg) {
		legDao.insertLeg(leg);
	}

	@Override
	public void updateLeg(Leg leg) {
		legDao.updateLeg(leg);
	}

	@Override
	public void deleteLeg(String airlineId, int flightNo, int legNo) {
		legDao.deleteLeg(airlineId, flightNo, legNo);
	}
}
