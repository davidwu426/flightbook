package flightbook.controller;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CreateCustomerRequest;
import flightbook.entity.customer.CustomerContact;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import flightbook.service.customer.ICustomerService;
import flightbook.service.person.IPersonService;
import flightbook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	ICustomerService customerService;

	@Autowired
	IPersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/contacts")
	public ResponseEntity<List<CustomerContact>> getCustomerContacts() {
		List<CustomerContact> customers = customerService.getAllCustomerContacts();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{accountNo}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int accountNo) {
		Customer customer = customerService.getCustomerByAccountNo(accountNo);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/username/{username}")
	public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
		Customer customer = customerService.getCustomerByUsername(username);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
		int id = personService.getNewId();
		int accountNo = customerService.getNewAccountNo();

		Person person = new Person(
				id,
				createCustomerRequest.getFirstName(),
				createCustomerRequest.getLastName(),
				createCustomerRequest.getTelephone(),
				createCustomerRequest.getAddress(),
				createCustomerRequest.getCity(),
				createCustomerRequest.getState(),
				createCustomerRequest.getZip()
		);

		Customer customer = new Customer(
				id,
				accountNo,
				createCustomerRequest.getCreditCardNo(),
				createCustomerRequest.getEmail(),
				new Date(),
				0
		);

		User user = new User(
				createCustomerRequest.getUsername(),
				createCustomerRequest.getPassword(),
				id
		);

		try {
			customerService.insertCustomer(user, person, customer);

			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{accountNo}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int accountNo, @RequestBody Customer customer) {
		Customer currentCustomer = customerService.getCustomerByAccountNo(accountNo);
		if (currentCustomer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		currentCustomer.setCreditCardNo(customer.getCreditCardNo());
		currentCustomer.setEmail(customer.getEmail());
		currentCustomer.setCreationDate(customer.getCreationDate());
		currentCustomer.setRating(customer.getRating());

		customerService.updateCustomer(currentCustomer);
		return new ResponseEntity<>(currentCustomer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{accountNo}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int accountNo) {
		try {
			customerService.deleteCustomer(accountNo);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
