package flightbook.dao;

import flightbook.model.Airline;
import flightbook.model.AirlineRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Repository
public class AirlineDao implements IAirlineDao {
	JdbcTemplate jdbcTemplate;

	public AirlineDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Airline> getAllAirlines() {
		String sql = "SELECT * FROM Airline";

		RowMapper<Airline> rowMapper = new AirlineRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Airline getAirlineById(String id) {
		String sql = "SELECT * FROM Airline WHERE Id = ?";

		RowMapper<Airline> rowMapper = new AirlineRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(Airline airline) {
		String sql = "INSERT INTO Airline (Id, Name) VALUES (?, ?)";

		this.jdbcTemplate.update(sql, airline.getId(), airline.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Airline airline) {
		String sql = "UPDATE Airline " +
				"SET Name = ? " +
				"WHERE Id = ?";

		this.jdbcTemplate.update(sql, airline.getName(), airline.getId());
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM Airline WHERE id = ?";

		this.jdbcTemplate.update(sql, id);
	}
}
