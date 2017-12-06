package flightbook.entity.leg;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LegRowMapper implements RowMapper<Leg>{
	@Override
	public Leg mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Leg(
				rs.getString("AirlineId"),
				rs.getInt("FlightNo"),
				rs.getInt("LegNo"),
				rs.getString("DepAirportId"),
				rs.getString("ArrAirportId"),
				new Date(rs.getTimestamp("ArrTime").getTime()),
				new Date(rs.getTimestamp("DepTime").getTime())
		);
	}
}
