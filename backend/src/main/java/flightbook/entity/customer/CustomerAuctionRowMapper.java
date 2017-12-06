package flightbook.entity.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAuctionRowMapper implements RowMapper<CustomerAuction> {
    @Override
    public CustomerAuction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerAuction(
            rs.getInt("AccountNo"),
            rs.getString("AirlineId"),
            rs.getInt("FlightNo"),
            rs.getString("Class"),
            rs.getDate("Date"),
            rs.getInt("NYOP")
        );
    }
}
