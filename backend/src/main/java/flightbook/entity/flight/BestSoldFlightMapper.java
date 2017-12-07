package flightbook.entity.flight;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BestSoldFlightMapper implements RowMapper<BestSoldFlight> {
    @Override
    public BestSoldFlight mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BestSoldFlight(
                rs.getInt("FlightNo"),
                rs.getDouble("BookingFee"),
                rs.getDouble("TotalFare")
        );
    }
}
