package flightbook.service.user;

import flightbook.Role;
import flightbook.dao.user.IUserDao;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements IUserService, UserDetailsService {
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);

		return new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(),
				getGrantedAuthorities(username));
	}

	/**
	 * Get role of user with specified username
	 *  Customer: person that is not an employee
	 *  Employee: employee that is not a manager
	 *  Manager: employee that is also a manager
	 *
	 * @param username  Username of user to get role of
	 * @return  Collection of roles of user
	 */
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		GrantedAuthority authority = new SimpleGrantedAuthority(Role.CUSTOMER);

		return Collections.singletonList(authority);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public void createUser(String username, String password, int id) {
		userDao.createUser(username, password, id);
	}
}
