package flightbook.controller;

import flightbook.entity.employee.CreateEmployeeRequest;
import flightbook.entity.employee.Employee;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import flightbook.service.employee.IEmployeeService;
import flightbook.service.person.IPersonService;
import flightbook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;

	@Autowired
	IPersonService personService;

	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{ssn}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int ssn) {
		Employee employee = employeeService.getEmployeeBySSN(ssn);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		int id = personService.getNewId();

		Person person = new Person(
				id,
				createEmployeeRequest.getFirstName(),
				createEmployeeRequest.getLastName(),
				createEmployeeRequest.getTelephone(),
				createEmployeeRequest.getAddress(),
				createEmployeeRequest.getCity(),
				createEmployeeRequest.getState(),
				createEmployeeRequest.getZip()
		);

		Employee employee = new Employee(
				id,
				createEmployeeRequest.getSSN(),
				false,
				createEmployeeRequest.getStartDate(),
				createEmployeeRequest.getHourlyWage()
		);

		User user = new User(
				createEmployeeRequest.getUsername(),
				createEmployeeRequest.getPassword(),
				id
		);

		try {
			personService.insertPerson(person);
			employeeService.insertEmployee(employee);
			userService.insertUser(user);

			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{ssn}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int ssn) {
		try {
			employeeService.deleteEmployee(ssn);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
