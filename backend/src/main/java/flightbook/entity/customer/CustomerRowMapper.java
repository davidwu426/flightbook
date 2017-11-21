package flightbook.entity.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(
				rs.getInt("Id"),
				rs.getInt("AccountNo"),
				rs.getString("CreditCardNo"),
				rs.getString("Email"),
				rs.getDate("CreationDate"),
				rs.getInt("Rating")
		);
	}
}
