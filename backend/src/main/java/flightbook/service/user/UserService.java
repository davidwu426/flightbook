package flightbook.service.user;

import flightbook.Role;
import flightbook.dao.customer.ICustomerDao;
import flightbook.dao.employee.IEmployeeDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.employee.Employee;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
		GrantedAuthority authority = new SimpleGrantedAuthority(getRoleByUsername(username));

		return Collections.singletonList(authority);
	}

	@Override
	@Transactional
	public String getRoleByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		int id = user.getId();

		return getRoleById(id);
	}

	@Override
	@Transactional
	public String getRoleById(int id) {
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

		return role;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
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
		userDao.insertUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
