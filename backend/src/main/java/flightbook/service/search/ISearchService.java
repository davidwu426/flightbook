package flightbook.service.search;

import flightbook.entity.search.SearchEntry;

import java.util.List;

public interface ISearchService {
    /**
     * Get list of sets of legs that reach destination (at most 3 legs)
     *
     * @return  A list of all search results
     */
    List<SearchEntry> getOneWayResults(String depAirport, String arrAirport, String depTime, String flightClass);
}
