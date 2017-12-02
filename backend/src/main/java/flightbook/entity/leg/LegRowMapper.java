package flightbook.entity.leg;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegRowMapper implements RowMapper<Leg>{
	@Override
	public Leg mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Leg(
				rs.getString("AirlineId"),
				rs.getInt("FlightNo"),
				rs.getInt("LegNo"),
				rs.getString("DepAirportId"),
				rs.getString("ArrAirportId"),
				rs.getDate("ArrTime"),
				rs.getDate("DepTime")
		);
	}
}
