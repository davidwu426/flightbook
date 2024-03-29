package flightbook.controller;

import flightbook.entity.employee.CreateEmployeeRequest;
import flightbook.entity.employee.Employee;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import flightbook.service.manager.IManagerService;
import flightbook.service.person.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
	@Autowired
	IManagerService managerService;

	@Autowired
	IPersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllManagers() {
		List<Employee> managers = managerService.getAllManagers();

		return new ResponseEntity<>(managers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{ssn}")
	public ResponseEntity<Employee> getManager(@PathVariable int ssn) {
		Employee manager = managerService.getManagerBySSN(ssn);
		if (manager == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(manager, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/username/{username}")
	public ResponseEntity<Employee> getManagerByUsername(@PathVariable String username) {
		Employee manager = managerService.getManagerByUsername(username);
		if (manager == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(manager, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> createManager(@RequestBody CreateEmployeeRequest createManagerRequest) {
		int id = personService.getNewId();

		Person person = new Person(
				id,
				createManagerRequest.getFirstName(),
				createManagerRequest.getLastName(),
				createManagerRequest.getTelephone(),
				createManagerRequest.getAddress(),
				createManagerRequest.getCity(),
				createManagerRequest.getState(),
				createManagerRequest.getZip()
		);

		Employee manager = new Employee(
				id,
				createManagerRequest.getSSN(),
				true,
				createManagerRequest.getStartDate(),
				createManagerRequest.getHourlyRate()
		);

		User user = new User(
				createManagerRequest.getUsername(),
				createManagerRequest.getPassword(),
				id
		);

		try {
			managerService.insertManager(user, person, manager);

			return new ResponseEntity<>(manager, HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{ssn}")
	public ResponseEntity<Employee> updateManager(@PathVariable int ssn, @RequestBody Employee manager) {
		Employee currentManager = managerService.getManagerBySSN(ssn);
		if (currentManager == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		currentManager.setStartDate(manager.getStartDate());
		currentManager.setHourlyRate(manager.getHourlyRate());

		managerService.updateManager(currentManager);
		return new ResponseEntity<>(currentManager, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{ssn}")
	public ResponseEntity<Employee> deleteManager(@PathVariable int ssn) {
		try {
			managerService.deleteManager(ssn);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
