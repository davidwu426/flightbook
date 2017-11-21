package flightbook.service.person;

import flightbook.Role;
import flightbook.entity.person.Person;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IPersonService {
	/**
	 * Get all people
	 *
	 * @return  A list of all people
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<Person> getAllPeople();

	/**
	 * Get person by id
	 *
	 * @param id  ID of person to get
	 * @return  Person with specified id
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Person getPersonById(int id);

	/**
	 * Creates a new person
	 *
	 * @param person    Person to create
	 */
	void insertPerson(Person person);

	/**
	 * Deletes a person
	 *
	 * @param id    ID of person to delete
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void deletePerson(int id);

	/**
	 * Generate a new ID for a new person
	 *
	 * @return  Newly generated unique ID
	 */
	int getNewId();
}
