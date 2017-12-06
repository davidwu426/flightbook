package flightbook.dao.flight;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.customer.CustomerOnFlightMapper;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FlightRowMapper;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.flight.FrequentFlightMapper;
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
		String sql = "SELECT * FROM Flight ORDER BY AirlineId";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Flight> getFlightsByAirline(String airlineId) {
		String sql = "SELECT * FROM Flight WHERE AirlineId = ?";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId);
	}

	@Override
	public List<Flight> getFlightsDepartingFromAirportOnDayOfWeek(String airportId, String dayOfWeekBinary) {
		String sql = "SELECT f.*\n" +
				"FROM Flight f, Leg l\n" +
				"WHERE f.DaysOperating & b?\n" +
				"AND f.AirlineId = l.AirlineId\n" +
				"AND f.FlightNo = l.FlightNo\n" +
				"AND l.DepAirportId = ?";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, dayOfWeekBinary, airportId);
	}

	public List<Flight> getFlightsByAirport(String airportId) {
		String sql = "SELECT f.* " +
				"FROM Airport a, Leg l, Flight f " +
				"WHERE a.Id = l.DepAirportID " +
				"AND f.FlightNo = l.FlightNo " +
				"AND a.Id = ?;";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airportId);
	}

	@Override
	public Flight getFlight(String airlineId, int flightNo) {
		String sql = "SELECT * FROM Flight WHERE AirlineId = ? AND FlightNo = ?";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, airlineId, flightNo);
	}

	@Override
	public List<FrequentFlight> getFrequentFlight() {

		String sql = "SELECT COUNT(distinct RP.ResrNo) AS ResrCount, I.FlightNo, I.AirlineId\n" +
				"FROM ReservationPassenger RP, Includes I\n" +
				"WHERE I.ResrNo = RP.ResrNo\n" +
				"GROUP By I.FlightNo\n" +
				"ORDER By ResrCount DESC\n" +
				"LIMIT 5";

		RowMapper<FrequentFlight> rowMapper = new FrequentFlightMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	@Override
	public List<CustomerOnFlight> getCustomerOnFlight(String airlineId, int flightNo) {
		String sql = "SELECT DISTINCT r.AccountNo, p.FirstName, p.LastName, r.ResrNo, rp.SeatNo, rp.Class, rp.Meal\n" +
				"FROM Person p, Reservation r, Passenger pass, ReservationPassenger rp, Includes i\n" +
				"WHERE p.Id = rp.Id\n" +
				"\tAND r.ResrNo = rp.ResrNo\n" +
				"\tAND i.ResrNo = rp.ResrNo\n" +
				"\tAND i.AirlineID = ?\n" +
				"\tAND i.FlightNo = ?;";

		RowMapper<CustomerOnFlight> rowMapper = new CustomerOnFlightMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId, flightNo);
	}

	@Override
	public List<Flight> getDelayedFlights() {
		String sql = "SELECT *\n" +
				"FROM Flight f\n" +
				"WHERE f.IsDelayed = TRUE;\n";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public void insertFlight(Flight flight) {
		String sql = "INSERT INTO Flight (AirlineId, FlightNo, NoOfSeats, DaysOperating, MinLengthOfStay, MaxLengthOfStay) " +
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
				"MinLengthOfStay = ?, " +
				"MaxLengthOfStay = ? " +
				"WHERE AirlineId = ? " +
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
		String sql = "DELETE FROM Flight WHERE AirlineId = ? AND FlightNo = ?";

		this.jdbcTemplate.update(sql, airlineId, flightNo);
	}
}
