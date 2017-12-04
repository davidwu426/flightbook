package flightbook.dao.search;

import flightbook.entity.flight.Flight;
import flightbook.entity.search.SearchEntry;

import java.util.Date;
import java.util.List;

public interface ISearchDao {


    List<SearchEntry> getOneWaySearch(String dayFlying);


}
