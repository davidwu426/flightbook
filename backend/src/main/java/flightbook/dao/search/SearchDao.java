package flightbook.dao.search;

import flightbook.entity.search.SearchEntry;
import flightbook.entity.search.SearchEntryRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Slf4j
@Repository
public class SearchDao implements ISearchDao {

    JdbcTemplate jdbcTemplate;

    public SearchDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<SearchEntry> getOneWaySearch(String dayFlying) {


        String sql = "SELECT F.FlightNo, A.Id as AirlineId, FA.Fare\n" +
                "FROM Flight F, Airline A, Fare FA\n" +
                "WHERE F.AirlineId = A.Id\n" +
                "AND F.FlightNo = FA.FlightNo\n" +
                "AND FA.AirlineId = A.Id\n" +
                "AND F.DaysOperating & b?";

        RowMapper<SearchEntry> rowMapper = new SearchEntryRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper, dayFlying);
    }
}
