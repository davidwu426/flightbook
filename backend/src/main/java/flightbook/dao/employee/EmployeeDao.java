package flightbook.dao.employee;

import flightbook.entity.employee.Employee;
import flightbook.entity.employee.EmployeeRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class EmployeeDao implements IEmployeeDao {
	JdbcTemplate jdbcTemplate;

	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM Employee WHERE IsManager = 0 ORDER BY Id";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Employee getEmployeeBySSN(int ssn) {
		String sql = "SELECT * FROM Employee WHERE SSN = ? AND IsManager = 0";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, ssn);
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		String sql = "SELECT e.* " +
				"FROM Employee e, User u " +
				"WHERE u.Username = ? " +
				"AND e.Id = u.Id " +
				"AND e.IsManager = 0";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, username);
	}

	@Override
	public Employee getEmployeeOrManagerById(int id) {
		String sql = "SELECT * FROM Employee WHERE Id = ?";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public void insertEmployee(Employee employee) {
		String sql = "INSERT INTO Employee (Id, SSN, IsManager, StartDate, HourlyRate) VALUES (?, ?, 0, ?, ?)";

		this.jdbcTemplate.update(sql,
				employee.getId(),
				employee.getSSN(),
				employee.getStartDate(),
				employee.getHourlyRate());
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE Employee " +
				"SET StartDate = ?, " +
				"HourlyRate = ? " +
				"WHERE SSN = ? " +
				"AND IsManager = 0";

		this.jdbcTemplate.update(sql,
				employee.getStartDate(),
				employee.getHourlyRate(),
				employee.getSSN());
	}

	@Override
	public void deleteEmployee(int ssn) {
		String sql = "DELETE Person " +
				"FROM Person " +
				"INNER JOIN Employee ON Employee.Id = Person.Id " +
				"WHERE Employee.SSN = ? AND Employee.IsManager = 0";

		this.jdbcTemplate.update(sql, ssn);
	}
}
