package flightbook.service.employee;

import flightbook.dao.employee.IEmployeeDao;
import flightbook.dao.person.IPersonDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.employee.Employee;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IPersonDao personDao;
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
	public Employee getEmployeeByUsername(String username) {
		try {
			return employeeDao.getEmployeeByUsername(username);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void insertEmployee(User user, Person person, Employee employee) {
		personDao.insertPerson(person);
		userDao.insertUser(user);
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int ssn) {
		employeeDao.deleteEmployee(ssn);
	}
}
