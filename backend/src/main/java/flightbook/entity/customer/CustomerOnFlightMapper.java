package flightbook.entity.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOnFlightMapper implements RowMapper<CustomerOnFlight> {
    @Override
    public CustomerOnFlight mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerOnFlight(
                rs.getInt("AccountNo"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getInt("ResrNo"),
                rs.getString("SeatNo"),
                rs.getString("Class"),
                rs.getString("Meal")
        );
    }
}
