package flightbook.service.customer;

import flightbook.Role;
import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerContact;
import flightbook.entity.flight.Flight;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ICustomerService {
	/**
	 * Get all customers
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<Customer> getAllCustomers();

	/**
	 * Get all customer contacts
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<CustomerContact> getAllCustomerContacts();

	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<Flight> getSuggestions(int accountNo);

	/**
	 * Find customer given account number of customer
	 *
	 * @param accountNo    Account number of customer
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Customer getCustomerByAccountNo(int accountNo);

	/**
	 * Find customer given username
	 *
	 * @param username    Username of customer
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Customer getCustomerByUsername(String username);

	/**
	 * Inserts a customer
	 *
	 * @param user      User entity to insert
	 * @param person    Person entity to insert
	 * @param customer  Customer entity to insert
	 */
	void insertCustomer(User user, Person person, Customer customer);

	/**
	 * Updates a customer
	 *
	 * @param customer  Customer to update
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void updateCustomer(Customer customer);

	/**
	 * Deletes a customer given an account number
	 *
	 * @param accountNo    Account number of customer to delete
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void deleteCustomer(int accountNo);

	/**
	 * Generate a new account ID for a new customer
	 *
	 * @return  Newly generated unique account ID
	 */
	int getNewAccountNo();
}
