package flightbook.dao.leg;

import flightbook.entity.leg.Leg;
import flightbook.entity.leg.LegRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class LegDao implements ILegDao {
	JdbcTemplate jdbcTemplate;

	public LegDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Leg> getAllLegs() {
		String sql = "SELECT * FROM Leg";

		RowMapper<Leg> rowMapper = new LegRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Leg> getLegsByAirline(String airlineId) {
		String sql = "SELECT * FROM LEG WHERE AirlineID = ?";

		RowMapper<Leg> rowMapper = new LegRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId);
	}

	@Override
	public List<Leg> getLegsByFlight(String airlineId, int flightNo) {
		String sql = "SELECT * FROM LEG WHERE AirlineID = ? AND FlightNo = ?";

		RowMapper<Leg> rowMapper = new LegRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId, flightNo);
	}

	@Override
	public Leg getLeg(String airlineId, int flightNo, int legNo) {
		String sql = "SELECT * FROM LEG WHERE AirlineID = ? AND FlightNo = ? AND LegNo = ?";

		RowMapper<Leg> rowMapper = new LegRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, airlineId, flightNo, legNo);
	}

	@Override
	public void insertLeg(Leg leg) {
		String sql = "INSERT INTO Leg (AirlineID, FlightNo, LegNo, DepAirportID, ArrAirportID, ArrTime, DepTime) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				leg.getAirlineId(),
				leg.getFlightNo(),
				leg.getLegNo(),
				leg.getDepAirportId(),
				leg.getArrAirportId(),
				leg.getArrTime(),
				leg.getDepTime());
	}

	@Override
	public void updateLeg(Leg leg) {
		String sql = "UPDATE Leg " +
				"SET DepAirportId = ?, " +
				"ArrAirportId = ?, " +
				"ArrTime = ? " +
				"DepTime = ? " +
				"WHERE AirlineID = ? " +
				"AND FlightNo = ? " +
				"AND LegNo = ?";

		jdbcTemplate.update(sql,
				leg.getDepAirportId(),
				leg.getArrAirportId(),
				leg.getArrTime(),
				leg.getDepTime(),
				leg.getAirlineId(),
				leg.getFlightNo(),
				leg.getLegNo());
	}

	@Override
	public void deleteLeg(String airlineId, int flightNo, int legNo) {
		String sql = "DELETE FROM Leg WHERE AirlineID = ? AND FlightNo = ? AND LegNo = ?";

		this.jdbcTemplate.update(sql, airlineId, flightNo, legNo);
	}
}
