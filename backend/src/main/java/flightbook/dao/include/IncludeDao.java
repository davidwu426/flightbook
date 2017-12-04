package flightbook.dao.include;

import flightbook.entity.include.Include;
import flightbook.entity.include.IncludeRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class IncludeDao implements IIncludeDao {
	JdbcTemplate jdbcTemplate;

	public IncludeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Include> getIncludesByResrNo(int resrNo) {
		String sql = "SELECT * FROM Includes WHERE ResrNo = ? ORDER BY LegNo";

		RowMapper<Include> rowMapper = new IncludeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, resrNo);
	}

	@Override
	public void insertInclude(Include include) {
		String sql = "INSERT INTO Includes (ResrNo, AirlineId, FlightNo, LegNo, FromStopNo, Date)\n" +
				"VALUES (?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				include.getResrNo(),
				include.getAirlineId(),
				include.getFlightNo(),
				include.getLegNo(),
				include.getFromLegNo(),
				include.getDate());
	}
}
