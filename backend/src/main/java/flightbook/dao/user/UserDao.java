package flightbook.dao.user;

import flightbook.entity.user.User;
import flightbook.entity.user.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDao implements IUserDao {
	JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM User WHERE Id = ?";

		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM User WHERE Username = ?";

		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, username);
	}

	@Override
	public void createUser(String username, String encodedPassword, int id) {
		String sql = "INSERT INTO User (Username, Password, Id) VALUES (?, ?, ?)";

		RowMapper<User> rowMapper = new UserRowMapper();
		this.jdbcTemplate.update(sql, rowMapper, username, encodedPassword, id);
	}
}
