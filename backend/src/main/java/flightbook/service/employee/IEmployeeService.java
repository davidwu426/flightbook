package flightbook.service.employee;

import flightbook.Role;
import flightbook.entity.employee.Employee;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IEmployeeService {
	/**
	 * Get all employees
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	List<Employee> getAllEmployees();

	/**
	 * Find employee given SSN of employee
	 *
	 * @param ssn    SSN of employee
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	Employee getEmployeeBySSN(int ssn);

	/**
	 * Inserts an employee
	 *
	 * @param  employee Employee to insert
	 */
	void insertEmployee(Employee employee);

	/**
	 * Deletes a employee given an account number
	 *
	 * @param ssn    SSN of employee to delete
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	void deleteEmployee(int ssn);
}
