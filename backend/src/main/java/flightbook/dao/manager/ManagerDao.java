package flightbook.dao.manager;

import flightbook.entity.employee.Employee;
import flightbook.entity.employee.EmployeeRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Repository
public class ManagerDao implements IManagerDao {
	JdbcTemplate jdbcTemplate;

	public ManagerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getAllManagers() {
		String sql = "SELECT * FROM Employee WHERE IsManager = 1";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Employee getManagerBySSN(int ssn) {
		String sql = "SELECT * FROM Employee WHERE SSN = ? AND IsManager = 1";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, ssn);
	}

	@Override
	public void insertManager(Employee manager) {
		String sql = "INSERT INTO Employee (Id, SSN, IsManager, StartDate, HourlyRate) VALUES (?, ?, 1, ?, ?)";

		this.jdbcTemplate.update(sql,
				manager.getId(),
				manager.getSSN(),
				manager.getStartDate(),
				manager.getHourlyRate());
	}

	@Override
	public void deleteManager(int ssn) {
		String sql = "DELETE FROM Employee WHERE SSN = ? AND IsManager = 1";

		this.jdbcTemplate.update(sql, ssn);
	}
}
