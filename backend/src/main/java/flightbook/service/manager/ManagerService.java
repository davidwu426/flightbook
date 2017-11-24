package flightbook.service.manager;

import flightbook.dao.manager.IManagerDao;
import flightbook.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements IManagerService {
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
	public void insertManager(Employee manager) {
		managerDao.insertManager(manager);
	}

	@Override
	public void deleteManager(int ssn) {
		managerDao.deleteManager(ssn);
	}
}
