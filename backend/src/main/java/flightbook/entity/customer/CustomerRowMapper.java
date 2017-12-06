package flightbook.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(
				rs.getInt("Id"),
				rs.getInt("AccountNo"),
				rs.getString("CreditCardNo"),
				rs.getString("Email"),
				new Date(rs.getTimestamp("CreationDate").getTime()),
				rs.getInt("Rating")
		);
	}
}
