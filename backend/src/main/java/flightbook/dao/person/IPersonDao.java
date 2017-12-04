package flightbook.dao.person;

import flightbook.entity.person.Person;

import java.util.List;

public interface IPersonDao {
	List<Person> getAllPeople();

	Person getPersonById(int id);

	Person getPersonByUsername(String username);

	void insertPerson(Person person);

	void updatePerson(Person person);

	void deletePerson(int id);

	int getNewId();
}
