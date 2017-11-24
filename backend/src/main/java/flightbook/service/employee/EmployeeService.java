package flightbook.service.employee;

import flightbook.dao.employee.IEmployeeDao;
import flightbook.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeBySSN(int ssn) {
		return employeeDao.getEmployeeBySSN(ssn);
	}

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void deleteEmployee(int ssn) {
		employeeDao.deleteEmployee(ssn);
	}
}
