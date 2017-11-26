package flightbook.service.person;

import flightbook.dao.person.IPersonDao;
import flightbook.dao.user.IUserDao;
import flightbook.entity.person.Person;
import flightbook.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IUserDao userDao;
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
	public Person getPersonByUsername(String username) {
		return personDao.getPersonByUsername(username);
	}

	@Override
	public void insertPerson(User user, Person person) {
		userDao.insertUser(user);
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
