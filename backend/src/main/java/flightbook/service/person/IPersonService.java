package flightbook.service.person;

import flightbook.Role;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
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
	 * Get person by ID
	 *
	 * @param id  ID of person to get
	 * @return  Person with specified ID
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Person getPersonById(int id);

	/**
	 * Get person by username
	 *
	 * @param username  Username of person to get
	 * @return  Person with specified username
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	Person getPersonByUsername(String username);

	/**
	 * Creates a new person
	 *
	 * @param user      User entity to insert
	 * @param person    Person entity to insert
	 */
	void insertPerson(User user, Person person);

	/**
	 * Updates a person
	 *
	 * @param person    Person to update
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void updatePerson(Person person);

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
