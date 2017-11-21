package flightbook.entity.person;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Person(
				rs.getInt("Id"),
				rs.getString("FirstName"),
				rs.getString("LastName"),
				rs.getString("Telephone"),
				rs.getString("Address"),
				rs.getString("City"),
				rs.getString("State"),
				rs.getInt("Zip")
		);
	}
}
