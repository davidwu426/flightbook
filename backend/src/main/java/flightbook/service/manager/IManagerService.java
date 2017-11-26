package flightbook.service.manager;

import flightbook.Role;
import flightbook.entity.employee.Employee;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IManagerService {
	/**
	 * Get all managers
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	List<Employee> getAllManagers();

	/**
	 * Find manager given SSN of manager
	 *
	 * @param ssn    SSN of manager
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	Employee getManagerBySSN(int ssn);

	/**
	 * Find manager given username
	 *
	 * @param username    Username of manager
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	Employee getManagerByUsername(String username);

	/**
	 * Inserts a manager
	 *
	 * @param user      User entity to insert
	 * @param person    Person entity to insert
	 * @param manager   Manager entity to insert
	 */
	void insertManager(User user, Person person, Employee manager);

	/**
	 * Deletes a manager given an account number
	 *
	 * @param ssn    SSN of manager to delete
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteManager(int ssn);
}
