package flightbook.entity.search;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEntryRowMapper implements RowMapper<SearchEntry> {
    @Override
    public SearchEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SearchEntry(
                rs.getInt("FlightNo"),
                rs.getString("AirlineId"),
                rs.getDouble("Fare")
        );
    }
}
