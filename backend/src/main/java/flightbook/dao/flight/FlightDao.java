package flightbook.dao.flight;

import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FlightRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class FlightDao implements IFlightDao {
	JdbcTemplate jdbcTemplate;

	public FlightDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Flight> getAllFlights() {
		String sql = "SELECT * FROM Flight";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Flight> getFlightsByAirline(String airlineId) {
		String sql = "SELECT * FROM Flight WHERE AirlineID = ?";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId);
	}

	@Override
	public Flight getFlight(String airlineId, int flightNo) {
		String sql = "SELECT * FROM Flight WHERE AirlineID = ? AND FlightNo = ?";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, airlineId, flightNo);
	}

	@Override
	public void insertFlight(Flight flight) {
		String sql = "INSERT INTO Flight (AirlineID, FlightNo, NoOfSeats, DaysOperating, MinLengthOfStay, MaxLengthOfStay) " +
				"VALUES (?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				flight.getAirlineId(),
				flight.getFlightNo(),
				flight.getNoOfSeats(),
				flight.getDaysOperating(),
				flight.getMinLengthOfStay(),
				flight.getMaxLengthOfStay());
	}

	@Override
	public void updateFlight(Flight flight) {
		String sql = "UPDATE Flight " +
				"SET NoOfSeats = ?, " +
				"DaysOperating = ?, " +
				"MinLengthOfStay = ? " +
				"MaxLengthOfStay = ? " +
				"WHERE AirlineID = ? " +
				"AND FlightNo = ?";

		jdbcTemplate.update(sql,
				flight.getNoOfSeats(),
				flight.getDaysOperating(),
				flight.getMinLengthOfStay(),
				flight.getMaxLengthOfStay(),
				flight.getAirlineId(),
				flight.getFlightNo());
	}

	@Override
	public void deleteFlight(String airlineId, int flightNo) {
		String sql = "DELETE FROM Airport WHERE AirlineID = ? AND FlightNo = ?";

		this.jdbcTemplate.update(sql, airlineId, flightNo);
	}
}
