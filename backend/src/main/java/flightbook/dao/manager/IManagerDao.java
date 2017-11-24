package flightbook.dao.manager;

import flightbook.entity.employee.Employee;

import java.util.List;

public interface IManagerDao {
	List<Employee> getAllManagers();

	Employee getManagerBySSN(int ssn);

	void insertManager(Employee manager);

	void deleteManager(int ssn);
}
