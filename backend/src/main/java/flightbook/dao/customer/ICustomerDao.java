package flightbook.dao.customer;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerAuction;
import flightbook.entity.customer.CustomerContact;
import flightbook.entity.flight.Flight;
import flightbook.entity.personCustomer.PersonCustomer;

import java.util.List;

public interface ICustomerDao {
	List<Customer> getAllCustomers();

	List<CustomerContact> getAllCustomerContacts();

	List<Flight> getSuggestions(int accountNo);

	List<CustomerAuction> getAuctionsByAccountNo(int accountNo);

	List<CustomerAuction> getAuction(String airlineId, int flightNo, String flightClass);

	Customer getCustomerByAccountNo(int accountNo);

	Customer getCustomerById(int id);

	Customer getCustomerByUsername(String username);

	void insertCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int accountNo);

	int getNewAccountNo();

	int getBestCustomerRep();

	PersonCustomer getBestCustomer();
}
