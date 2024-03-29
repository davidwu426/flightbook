package flightbook.entity.include;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IncludeRowMapper implements RowMapper<Include> {
	@Override
	public Include mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Include(
				rs.getInt("ResrNo"),
				rs.getString("AirlineId"),
				rs.getInt("FlightNo"),
				rs.getInt("LegNo"),
				rs.getInt("FromStopNo"),
				new Date(rs.getTimestamp("Date").getTime())
		);
	}
}
