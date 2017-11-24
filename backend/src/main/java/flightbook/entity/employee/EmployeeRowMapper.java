package flightbook.entity.employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(
				rs.getInt("Id"),
				rs.getInt("SSN"),
				rs.getBoolean("IsManager"),
				rs.getDate("StartDate"),
				rs.getDouble("HourlyRate")
		);
	}
}
