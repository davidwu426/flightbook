package flightbook.entity.fare;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FareRowMapper implements RowMapper<Fare> {
	@Override
	public Fare mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Fare(
				rs.getString("AirlineId"),
				rs.getInt("FlightNo"),
				rs.getString("FareType"),
				rs.getString("Class"),
				rs.getDouble("Fare")
		);
	}
}
