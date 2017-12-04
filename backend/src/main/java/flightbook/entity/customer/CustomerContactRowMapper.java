package flightbook.entity.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerContactRowMapper implements RowMapper<CustomerContact> {
    @Override
    public CustomerContact mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerContact(
            rs.getString("FirstName"),
            rs.getString("LastName"),
            rs.getString("Telephone"),
            rs.getString("Address"),
            rs.getString("City"),
            rs.getString("State"),
            rs.getInt("ZipCode"),
            rs.getString("Email")
        );
    }
}
