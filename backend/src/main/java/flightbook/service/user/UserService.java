package flightbook.service.user;

import flightbook.Role;
import flightbook.dao.customer.ICustomerDao;
import flightbook.dao.employee.IEmployeeDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.employee.Employee;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ICustomerDao customerDao;
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);

		return new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(),
				getGrantedAuthorities(username));
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		User user = userDao.getUserByUsername(username);
		int id = user.getId();
		String role;

		try {
			// customer
			customerDao.getCustomerById(id);
			role = Role.CUSTOMER;
		} catch (DataAccessException  e1) {
			try {
				// employee
				Employee employee = employeeDao.getEmployeeOrManagerById(id);
				if (!employee.isManager()) {
					role = Role.EMPLOYEE;
				} else {
					role = Role.MANAGER;
				}
			} catch (DataAccessException e2) {
				role = Role.ADMIN;
			}
		}

		GrantedAuthority authority = new SimpleGrantedAuthority(role);

		return Collections.singletonList(authority);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertUser(User user) {
		userDao.createUser(user.getUsername(), encodePassword(user.getPassword()), user.getId());
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	/**
	 * Encrypts a password with BCrypt
	 *
	 * @param plaintextPassword  Plaintext password to encode
	 * @return  Encoded password
	 */
	private String encodePassword(String plaintextPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plaintextPassword);
	}
}
