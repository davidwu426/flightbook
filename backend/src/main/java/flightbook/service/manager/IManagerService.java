package flightbook.service.manager;

import flightbook.Role;
import flightbook.entity.employee.Employee;
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
	 * Inserts an manager
	 *
	 * @param  manager Manager to insert
	 */
	void insertManager(Employee manager);

	/**
	 * Deletes a manager given an account number
	 *
	 * @param ssn    SSN of manager to delete
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteManager(int ssn);
}
