package flightbook.service.manager;

import flightbook.dao.manager.IManagerDao;
import flightbook.dao.person.IPersonDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.employee.Employee;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerService implements IManagerService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IPersonDao personDao;
	@Autowired
	private IManagerDao managerDao;

	@Override
	public List<Employee> getAllManagers() {
		return managerDao.getAllManagers();
	}

	@Override
	public Employee getManagerBySSN(int ssn) {
		return managerDao.getManagerBySSN(ssn);
	}

	@Override
	public Employee getManagerByUsername(String username) {
		return managerDao.getManagerByUsername(username);
	}

	@Override
	@Transactional
	public void insertManager(User user, Person person, Employee manager) {
		userDao.insertUser(user);
		personDao.insertPerson(person);
		managerDao.insertManager(manager);
	}

	@Override
	public void deleteManager(int ssn) {
		managerDao.deleteManager(ssn);
	}
}
