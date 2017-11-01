package flightbook.dao;

import flightbook.model.Airline;
import flightbook.model.AirlineRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
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

		try {
			RowMapper<Airline> rowMapper = new AirlineRowMapper();
			return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (DataAccessException e) {
			log.warn("Attempted to retrieve airline with ID of {0} but returned none", id);

			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(Airline airline) {
		String sql = "INSERT INTO Airline (Id, Name) VALUES (?, ?)";

		this.jdbcTemplate.update(sql, airline.getId(), airline.getName());
	}
}
