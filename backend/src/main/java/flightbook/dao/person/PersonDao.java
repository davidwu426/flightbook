package flightbook.dao.person;

import flightbook.entity.person.Person;
import flightbook.entity.person.PersonRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PersonDao implements IPersonDao {
	JdbcTemplate jdbcTemplate;

	public PersonDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Person> getAllPeople() {
		String sql = "SELECT * FROM Person";

		RowMapper<Person> rowMapper = new PersonRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Person getPersonById(int id) {
		String sql = "SELECT * FROM Person WHERE Id = ?";

		RowMapper<Person> rowMapper = new PersonRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public Person getPersonByUsername(String username) {
		String sql = "SELECT p.* " +
				"FROM Person p, User u " +
				"WHERE u.Username = ? " +
				"AND p.Id = u.Id;";

		RowMapper<Person> rowMapper = new PersonRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, username);
	}

	@Override
	public void insertPerson(Person person) {
		String sql = "INSERT INTO Person (Id, FirstName, LastName, Telephone, Address, City, State, ZipCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				person.getId(),
				person.getFirstName(),
				person.getLastName(),
				person.getTelephone(),
				person.getAddress(),
				person.getCity(),
				person.getState(),
				person.getZip());
	}

	@Override
	public void deletePerson(int id) {
		String sql = "DELETE FROM Person WHERE Id = ?";

		this.jdbcTemplate.update(sql, id);
	}

	@Override
	public int getNewId() {
		String sql = "SELECT Id FROM Person ORDER BY Id DESC LIMIT 1";

		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max + 1;
	}
}
