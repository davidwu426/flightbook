package flightbook.dao.user;

import flightbook.entity.user.User;
import flightbook.entity.user.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	BCryptPasswordEncoder encoder;

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
	public void insertUser(User user) {
		String sql = "INSERT INTO User (Username, Password, Id) VALUES (?, ?, ?)";

		this.jdbcTemplate.update(sql, user.getUsername(), encoder.encode(user.getPassword()), user.getId());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM User WHERE Id = ?";

		this.jdbcTemplate.update(sql, id);
	}
}
