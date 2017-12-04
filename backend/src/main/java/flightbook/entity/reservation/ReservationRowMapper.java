package flightbook.entity.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<Reservation> {
	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Reservation(
				rs.getInt("ResrNo"),
				rs.getDate("ResrDate"),
				rs.getDouble("BookingFee"),
				rs.getDouble("TotalFare"),
				rs.getInt("RepSSN"),
				rs.getInt("AccountNo")
		);
	}
}
