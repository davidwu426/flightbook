package flightbook.entity.flight;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FrequentFlightMapper implements RowMapper<FrequentFlight> {

    @Override
    public FrequentFlight mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FrequentFlight(
                rs.getString( "AirlineId"),
                rs.getInt("ResrCount"),
                rs.getInt("FlightNo")
        );
    }
}
