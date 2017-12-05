package flightbook.dao.fare;

import flightbook.entity.fare.Fare;
import flightbook.entity.fare.FareRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class FareDao implements IFareDao {
	JdbcTemplate jdbcTemplate;

	public FareDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public double getFare(String airlineId, int flightNo, String fareType, String flightClass) {
		String sql = "SELECT * FROM Fare WHERE AirlineId = ? AND FlightNo = ? AND FareType = ? AND Class = ?";

		RowMapper<Fare> rowMapper = new FareRowMapper();
		Fare fare = jdbcTemplate.queryForObject(sql, rowMapper,
				airlineId, flightNo, fareType, flightClass);

		return fare.getFare();
	}
}
