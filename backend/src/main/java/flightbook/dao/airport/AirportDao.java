package flightbook.dao.Airport;

import flightbook.entity.airport.Airport;
import flightbook.entity.airport.AirportRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AirportDao implements IAirportDao {
	JdbcTemplate jdbcTemplate;

	public AirportDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Airport> getAllAirports() {
		String sql = "SELECT * FROM Airport ORDER BY Id";

		RowMapper<Airport> rowMapper = new AirportRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Airport getAirportById(String id) {
		String sql = "SELECT * FROM Airport WHERE Id = ?";

		RowMapper<Airport> rowMapper = new AirportRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public void insertAirport(Airport airport) {
		String sql = "INSERT INTO Airport (Id, Name, City, Country) VALUES (?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				airport.getId(),
				airport.getName(),
				airport.getCity(),
				airport.getCountry());
	}

	@Override
	public void updateAirport(Airport airport) {
		String sql = "UPDATE Airport " +
				"SET Name = ?, " +
				"City = ?, " +
				"Country = ? " +
				"WHERE Id = ?";

		this.jdbcTemplate.update(sql,
				airport.getName(),
				airport.getCity(),
				airport.getCountry(),
				airport.getId());
	}

	@Override
	public void deleteAirport(String id) {
		String sql = "DELETE FROM Airport WHERE Id = ?";

		this.jdbcTemplate.update(sql, id);
	}
}
