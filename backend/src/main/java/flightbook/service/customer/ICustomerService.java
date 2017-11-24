package flightbook.service.customer;

import flightbook.Role;
import flightbook.entity.customer.Customer;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ICustomerService {
	/**
	 * Get all customers
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<Customer> getAllCustomers();

	/**
	 * Find customer given account number of customer
	 *
	 * @param accountNo    Account number of customer
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Customer getCustomerByAccountNo(int accountNo);

	/**
	 * Inserts a customer
	 *
	 * @param customer  Customer to insert
	 */
	void insertCustomer(Customer customer);

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
