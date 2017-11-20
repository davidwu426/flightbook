package flightbook.service.user;

import flightbook.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
	/**
	 * Get user by ID
	 *
	 * @return  User with ID of specified ID
	 */
	User getUserById(int id);

	/**
	 * Get user by username
	 *
	 * @param username  Username of user to get
	 * @return  User with specified username
	 */
	User getUserByUsername(String username);

	/**
	 * Creates a new user with username, encrypted password, and person ID
	 *
	 * @param username  Username of user to create
	 * @param password  Raw password of user to create
	 * @param id        ID of user to create (should reference Person ID)
	 */
	void createUser(String username, String password, int id);
}
