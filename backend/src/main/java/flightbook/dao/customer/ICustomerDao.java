package flightbook.dao.customer;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerContact;

import java.util.List;

public interface ICustomerDao {
	List<Customer> getAllCustomers();

	List<CustomerContact> getAllCustomerContacts();

	Customer getCustomerByAccountNo(int accountNo);

	Customer getCustomerById(int id);

	Customer getCustomerByUsername(String username);

	void insertCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int accountNo);

	int getNewAccountNo();
}
