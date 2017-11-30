package flightbook.dao.leg;

import flightbook.entity.leg.Leg;

import java.util.List;

public interface ILegDao {
	List<Leg> getAllLegs();

	List<Leg> getLegsByAirline(String airlineId);

	List<Leg> getLegsByFlight(String airlineId, int flightNo);

	Leg getLeg(String airlineId, int flightNo, int legNo);

	void insertLeg(Leg leg);

	void updateLeg(Leg leg);

	void deleteLeg(String airlineId, int flightNo, int legNo);
}
