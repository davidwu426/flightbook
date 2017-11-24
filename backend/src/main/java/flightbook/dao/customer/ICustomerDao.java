package flightbook.dao.customer;

import flightbook.entity.customer.Customer;

import java.util.List;

public interface ICustomerDao {
	List<Customer> getAllCustomers();

	Customer getCustomerByAccountNo(int accountNo);

	Customer getCustomerById(int id);

	void insertCustomer(Customer customer);

	void deleteCustomer(int accountNo);

	int getNewAccountNo();
}
