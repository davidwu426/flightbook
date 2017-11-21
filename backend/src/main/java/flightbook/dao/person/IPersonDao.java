package flightbook.dao.person;

import flightbook.entity.person.Person;

import java.util.List;

public interface IPersonDao {
	List<Person> getAllPeople();

	Person getPersonById(int id);

	void insertPerson(Person person);

	void deletePerson(int id);

	int getNewId();
}
