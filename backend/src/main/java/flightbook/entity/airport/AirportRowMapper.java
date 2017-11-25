package flightbook.entity.airport;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportRowMapper implements RowMapper<Airport> {
	@Override
	public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Airport(
				rs.getString("Id"),
				rs.getString("Name"),
				rs.getString("City"),
				rs.getString("Country")
		);
	}
}
