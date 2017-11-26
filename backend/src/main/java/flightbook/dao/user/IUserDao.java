package flightbook.dao.user;

import flightbook.entity.user.User;

import java.util.List;

public interface IUserDao {
	List<User> getAllUsers();

	User getUserById(int id);

	User getUserByUsername(String username);

	void insertUser(User user);

	void deleteUser(int id);
}
