package flightbook.service.user;

import flightbook.Role;
import flightbook.dao.user.IUserDao;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
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
		GrantedAuthority authority = new SimpleGrantedAuthority(Role.CUSTOMER);

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
	public void createUser(String username, String plaintextPassword, int id) {
		userDao.createUser(username, encodePassword(plaintextPassword), id);
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
