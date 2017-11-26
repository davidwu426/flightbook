package flightbook.controller;

import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import flightbook.service.person.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	@Autowired
	IPersonService personService;

	@RequestMapping(method = RequestMethod.GET, value="/username/{username}")
	public ResponseEntity<Person> getPersonByUsername(@PathVariable String username) {
		Person person = personService.getPersonByUsername(username);

		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/id/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable int id) {
		Person person = personService.getPersonById(id);

		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}
