package flightbook.entity.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ReservationRowMapper implements RowMapper<Reservation> {
	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Reservation(
				rs.getInt("ResrNo"),
				new Date(rs.getTimestamp("ResrDate").getTime()),
				rs.getDouble("BookingFee"),
				rs.getDouble("TotalFare"),
				rs.getInt("RepSSN"),
				rs.getInt("AccountNo")
		);
	}
}
