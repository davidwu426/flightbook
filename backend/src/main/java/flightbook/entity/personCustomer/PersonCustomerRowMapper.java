package flightbook.entity.personCustomer;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonCustomerRowMapper implements RowMapper<PersonCustomer> {

    @Override
    public PersonCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PersonCustomer(
                rs.getInt("id"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("Telephone"),
                rs.getString("Address"),
                rs.getString("City"),
                rs.getString("State"),
                rs.getInt("ZipCode"),
                rs.getInt("AccountNo"),
                rs.getString("CreditCardNo"),
                rs.getString("Email"),
                rs.getDate("CreationDate"),
                rs.getInt("Rating"),
                rs.getDouble("BookingFee")

        );
    }
}
