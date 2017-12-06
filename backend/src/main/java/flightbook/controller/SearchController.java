package flightbook.controller;


import flightbook.entity.search.SearchEntry;
import flightbook.service.search.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
