package flightbook.controller;

import flightbook.entity.person.CreateAdminRequest;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import flightbook.service.person.IPersonService;
import flightbook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	@Autowired
	IPersonService personService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> createAdmin(@RequestBody CreateAdminRequest createAdminRequest) {
		int id = personService.getNewId();

		Person person = new Person(
				id,
				createAdminRequest.getFirstName(),
				createAdminRequest.getLastName(),
				createAdminRequest.getTelephone(),
				createAdminRequest.getAddress(),
				createAdminRequest.getCity(),
				createAdminRequest.getState(),
				createAdminRequest.getZip()
		);

		User user = new User(
				createAdminRequest.getUsername(),
				createAdminRequest.getPassword(),
				id
		);

		try {
			personService.insertPerson(user, person);

			return new ResponseEntity<>(person, HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
