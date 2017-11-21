package flightbook.service.person;

import flightbook.dao.person.IPersonDao;
import flightbook.entity.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonDao personDao;

	@Override
	public List<Person> getAllPeople() {
		return personDao.getAllPeople();
	}

	@Override
	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

	@Override
	public void insertPerson(Person person) {
		personDao.insertPerson(person);
	}

	@Override
	public void deletePerson(int id) {
		personDao.deletePerson(id);
	}

	@Override
	public int getNewId() {
		return personDao.getNewId();
	}
}