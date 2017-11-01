package flightbook.dao;

import flightbook.entity.Airline;
import flightbook.entity.AirlineRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public void insert(Airline airline) {
		String sql = "INSERT INTO Airline (Id, Name) VALUES (?, ?)";

		this.jdbcTemplate.update(sql, airline.getId(), airline.getName());
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
}
