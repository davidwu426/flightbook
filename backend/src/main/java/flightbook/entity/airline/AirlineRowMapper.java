package flightbook.entity.airline;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlineRowMapper implements RowMapper<Airline> {
	@Override
	public Airline mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Airline(
				rs.getString("Id"),
				rs.getString("Name")
		);
	}
}
