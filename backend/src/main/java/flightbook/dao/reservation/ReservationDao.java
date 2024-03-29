package flightbook.dao.reservation;

import flightbook.entity.reservation.Reservation;
import flightbook.entity.reservation.ReservationRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ReservationDao implements IReservationDao {
	JdbcTemplate jdbcTemplate;

	public ReservationDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Reservation> getAllReservations() {
		String sql = "SELECT * FROM Reservation ORDER BY ResrNo";

		RowMapper<Reservation> rowMapper = new ReservationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Reservation getReservationByNo(int resrNo) {
		String sql = "SELECT * FROM Reservation WHERE ResrNo = ?";

		RowMapper<Reservation> rowMapper = new ReservationRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, resrNo);
	}

	@Override
	public List<Reservation> getReservationsByFlight(String airlineId, int flightNo) {
		String sql = "SELECT r.*\n" +
				"FROM Reservation r, Includes i\n" +
				"WHERE i.AirlineId = ? AND i.FlightNo = ?\n" +
				"AND r.ResrNo = i.ResrNo\n" +
				"ORDER BY r.ResrNo";

		RowMapper<Reservation> rowMapper = new ReservationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId, flightNo);
	}

	@Override
	public List<Reservation> getReservationsByAccountNo(int accountNo) {
		String sql = "SELECT * FROM Reservation WHERE AccountNo = ? ORDER BY ResrNo";

		RowMapper<Reservation> rowMapper = new ReservationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, accountNo);
	}

	@Override
	public List<Reservation> getReservationsByCustomerName(String firstName, String lastName) {
		String sql = "SELECT r.*\n" +
				"FROM Reservation r, Person p, Customer c\n" +
				"WHERE r.AccountNo = c.AccountNo\n" +
				"AND p.Id = c.Id\n" +
				"AND p.FirstName = ?\n" +
				"AND p.LastName = ?\n" +
				"ORDER BY r.ResrNo;";

		RowMapper<Reservation> rowMapper = new ReservationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, firstName, lastName);
	}

	@Override
	public void insertReservation(Reservation reservation) {
		String sql = "INSERT INTO Reservation (ResrNo, ResrDate, BookingFee, TotalFare, RepSSN, AccountNo)\n" +
				"VALUES (?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				reservation.getResrNo(),
				reservation.getResrDate(),
				reservation.getBookingFee(),
				reservation.getTotalFare(),
				reservation.getRepSSN(),
				reservation.getAccountNo());
	}

	@Override
	public void deleteReservation(int resrNo) {
		String sql = "DELETE FROM Reservation WHERE ResrNo = ?";

		this.jdbcTemplate.update(sql, resrNo);
	}

	@Override
	public double getReservationByMonth(int month,int year) {
		String sql = "SELECT SUM(BookingFee) AS BookingFee\n" +
				"FROM Reservation\n" +
				"WHERE MONTH(ResrDate) = ?\n" +
				"AND YEAR(ResrDate) = ?;";
		Double revenue = this.jdbcTemplate.queryForObject(sql, Double.class, month, year);
		return revenue;
	}

	@Override
	public double getRevenueByFlight(String airlineId, int flightNo) {
		String sql = "SELECT SUM(BookingFee) " +
				"FROM (SELECT r.ResrNo, i.AirlineId, i.FlightNo, r.TotalFare, r.BookingFee " +
				"FROM Includes i, Reservation r " +
				"WHERE i.ResrNo = r.ResrNo " +
				"GROUP BY i.AirlineId, i.FlightNo) AS RevenueByFlight " +
				"WHERE RevenueByFlight.AirlineId = ? " +
				"AND RevenueByFlight.FlightNo = ?; ";

		Double revenue = this.jdbcTemplate.queryForObject(sql, Double.class, airlineId, flightNo);
		return revenue;
	}

	@Override
	public double getRevenueByCity(String city) {
		String sql = "SELECT SUM(BookingFee)\n" +
				"FROM Reservation r, Airport a, Leg l, Includes I\n" +
				"WHERE r.ResrNo = I.ResrNo\n" +
				"AND l.LegNo = I.LegNo\n" +
				"AND l.ArrAirportId = a.Id\n" +
				"AND a.City = ?;";

		Double revenue = this.jdbcTemplate.queryForObject(sql, Double.class, city);
		return revenue;
	}

	@Override
	public double getRevenueByAccountNo(int accountNo) {
		String sql = "SELECT SUM(BookingFee)\n" +
				"FROM Reservation r\n" +
				"WHERE r.AccountNo = ?;\n";

		Double revenue = this.jdbcTemplate.queryForObject(sql, Double.class, accountNo);
		return revenue;
	}

	@Override
	public int getNewReservationNo() {
		String sql = "SELECT ResrNo FROM Reservation ORDER BY ResrNo DESC LIMIT 1";

		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max + 1;
	}
}
