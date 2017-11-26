package flightbook.dao.employee;

import flightbook.entity.employee.Employee;

import java.util.List;

public interface IEmployeeDao {
	List<Employee> getAllEmployees();

	Employee getEmployeeBySSN(int ssn);

	Employee getEmployeeByUsername(String username);

	Employee getEmployeeOrManagerById(int id);

	void insertEmployee(Employee employee);

	void deleteEmployee(int ssn);
}
