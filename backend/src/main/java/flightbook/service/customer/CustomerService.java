package flightbook.service.customer;

import flightbook.dao.customer.ICustomerDao;
import flightbook.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
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
	public void insertCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
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
