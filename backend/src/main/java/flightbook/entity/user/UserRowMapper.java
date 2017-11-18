package flightbook.entity.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(
				rs.getString("Username"),
				rs.getString("Password"),
				rs.getInt("Id")
		);
	}
}
