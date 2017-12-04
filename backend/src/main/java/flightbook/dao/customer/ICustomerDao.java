package flightbook.dao.customer;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerContact;
import flightbook.entity.flight.Flight;

import java.util.List;

public interface ICustomerDao {
	List<Customer> getAllCustomers();

	List<CustomerContact> getAllCustomerContacts();

	List<Flight> getSuggestions(int accountNo);

	Customer getCustomerByAccountNo(int accountNo);

	Customer getCustomerById(int id);

	Customer getCustomerByUsername(String username);

	void insertCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int accountNo);

	int getNewAccountNo();
}
