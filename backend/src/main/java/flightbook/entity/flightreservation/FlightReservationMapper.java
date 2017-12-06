package flightbook.entity.flightreservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightReservationMapper implements RowMapper<FlightReservation> {
    @Override
    public FlightReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FlightReservation(
                rs.getString("AirlineId"),
                rs.getInt( "FlightNo"),
                rs.getInt("ResrCount")
        );
    }
}
