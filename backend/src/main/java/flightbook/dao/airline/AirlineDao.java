package flightbook.dao.airline;

import flightbook.entity.airline.Airline;
import flightbook.entity.airline.AirlineRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AirlineDao implements IAirlineDao {
	JdbcTemplate jdbcTemplate;

	public AirlineDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Airline> getAllAirlines() {
		String sql = "SELECT * FROM Airline ORDER BY AirlineId";

		RowMapper<Airline> rowMapper = new AirlineRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Airline getAirlineById(String id) {
		String sql = "SELECT * FROM Airline WHERE Id = ?";

		RowMapper<Airline> rowMapper = new AirlineRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public void insertAirline(Airline airline) {
		String sql = "INSERT INTO Airline (Id, Name) VALUES (?, ?)";

		this.jdbcTemplate.update(sql, airline.getId(), airline.getName());
	}

	@Override
	public void updateAirline(Airline airline) {
		String sql = "UPDATE Airline " +
				"SET Name = ? " +
				"WHERE Id = ?";

		this.jdbcTemplate.update(sql, airline.getName(), airline.getId());
	}

	@Override
	public void deleteAirline(String id) {
		String sql = "DELETE FROM Airline WHERE Id = ?";

		this.jdbcTemplate.update(sql, id);
	}
}
