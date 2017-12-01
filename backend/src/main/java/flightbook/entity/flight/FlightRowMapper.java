package flightbook.entity.flight;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightRowMapper implements RowMapper<Flight>{
	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Flight(
				rs.getString("AirlineId"),
				rs.getInt("FlightNo"),
				rs.getInt("NoOfSeats"),
				rs.getString("DaysOperating"),
				rs.getInt("MinLengthOfStay"),
				rs.getInt("MaxLengthOfStay"),
				rs.getBoolean("IsDelayed")
		);
	}
}
