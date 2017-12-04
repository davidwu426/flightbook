package flightbook.service.search;

import flightbook.entity.search.SearchEntry;

import java.util.List;

public interface ISearchService {

    /**
     * Get one way results
     *
     * @return  A list of all people
     */
    List<SearchEntry> getOneWayResults(String depTime);

}
