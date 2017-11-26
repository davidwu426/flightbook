package flightbook.service.user;

import flightbook.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

public interface IUserService extends UserDetailsService {
	/**
	 * Get role of user with specified username
	 *  Customer: person that is not an employee
	 *  Employee: employee that is not a manager
	 *  Manager: employee that is also a manager
	 *
	 * @param username  Username of user to get role of
	 * @return  Collection of roles of user
	 */
	Collection<? extends GrantedAuthority> getGrantedAuthorities(String username);

	/**
	 * Returns the role of a user
	 *
	 * @param username  Username of user to get role of
	 * @return  Role of user
	 */
	String getRoleByUsername(String username);

	/**
	 * Returns the role of a user given ID of user
	 *
	 * @param id    ID of user to get role of
	 * @return  Role of user
	 */
	String getRoleById(int id);

	/**
	 * Get all users
	 *
	 * @return  List of all users
	 */
	List<User> getAllUsers();

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
	 * Creates a new user with an unencrypted password.
	 *
	 * @param user  User to create
	 */
	void insertUser(User user);

	/**
	 * Deletes a user
	 *
	 * @param id    ID of user to delete
	 */
	void deleteUser(int id);
}
