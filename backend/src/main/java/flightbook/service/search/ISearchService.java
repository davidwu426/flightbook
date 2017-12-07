package flightbook.service.search;

import flightbook.entity.search.SearchCriteria;
import flightbook.entity.search.SearchEntry;

import java.util.List;

public interface ISearchService {
    /**
     * Get list of one way trip flights that satisfy search criteria
     *
     * @return  List of all search results
     */
    List<SearchEntry> getOneWayResults(String depAirport, String arrAirport, String depDate, String flightClass);

	/**
	 * Get list of round trip flights that satisfy search criteria
	 *
	 * @return  List of search results containing 2 flights
	 */
    List<List<SearchEntry>> getRoundTripResults(String depAirport, String arrAirport, String depDate, String retDate, String flightClass);

	/**
	 * Get list of multi city trip flights that satisfy search criteria
	 *
	 * @return  List of search results containing list of flights for each leg
	 */
	List<List<SearchEntry>> getMultiCityTripResults(List<SearchCriteria> searchCriteria, String flightClass);
}
