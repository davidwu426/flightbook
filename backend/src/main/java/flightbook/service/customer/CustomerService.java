package flightbook.service.customer;

import flightbook.dao.customer.ICustomerDao;
import flightbook.dao.person.IPersonDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.customer.Customer;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IPersonDao personDao;
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerByAccountNo(int accountNo) {
		return customerDao.getCustomerByAccountNo(accountNo);
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		try {
			return customerDao.getCustomerByUsername(username);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void insertCustomer(User user, Person person, Customer customer) {
		personDao.insertPerson(person);
		userDao.insertUser(user);
		customerDao.insertCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int accountNo) {
		customerDao.deleteCustomer(accountNo);
	}

	@Override
	public int getNewAccountNo() {
		return customerDao.getNewAccountNo();
	}
}
