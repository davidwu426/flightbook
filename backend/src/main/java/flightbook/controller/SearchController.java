package flightbook.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import flightbook.entity.search.SearchCriteria;
import flightbook.entity.search.SearchEntry;
import flightbook.service.search.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
	@Autowired
	private ISearchService search;

	@RequestMapping(method = RequestMethod.GET, value = "/oneway", params = {"depAirport", "arrAirport", "depDate", "flightClass"})
	public ResponseEntity<List<SearchEntry>> getOneWayFlights(@RequestParam("depAirport") String depAirport,
	                                                          @RequestParam("arrAirport") String arrAirport,
	                                                          @RequestParam("depDate") String depDate,
	                                                          @RequestParam("flightClass") String flightClass) {
		List<SearchEntry> searchEntries = search.getOneWayResults(depAirport, arrAirport, depDate, flightClass);

		return new ResponseEntity<>(searchEntries, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/roundtrip", params = {"depAirport", "arrAirport", "depDate", "retDate", "flightClass"})
	public ResponseEntity<List<List<SearchEntry>>> getRoundTripFlights(@RequestParam("depAirport") String depAirport,
	                                                                   @RequestParam("arrAirport") String arrAirport,
	                                                                   @RequestParam("depDate") String depDate,
	                                                                   @RequestParam("retDate") String retDate,
	                                                                   @RequestParam("flightClass") String flightClass) {
		List<List<SearchEntry>> searchEntries = search.getRoundTripResults(depAirport, arrAirport, depDate, retDate, flightClass);

		return new ResponseEntity<>(searchEntries, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/multicity", params = {"searchCriteria", "flightClass"})
	public ResponseEntity<List<List<SearchEntry>>> getMultiCityFlights(@RequestParam("searchCriteria") String searchCriteriaJson,
	                                                                   @RequestParam("flightClass") String flightClass) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<SearchCriteria> searchCriteria = mapper.readValue(searchCriteriaJson, new TypeReference<List<SearchCriteria>>() {
			});
			List<List<SearchEntry>> searchEntries = search.getMultiCityTripResults(searchCriteria, flightClass);

			return new ResponseEntity<>(searchEntries, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
