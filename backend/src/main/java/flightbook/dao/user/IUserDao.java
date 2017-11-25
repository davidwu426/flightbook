package flightbook.dao.user;

import flightbook.entity.user.User;

public interface IUserDao {
	User getUserById(int id);

	User getUserByUsername(String username);

	void insertUser(User user);

	void deleteUser(int id);
}
