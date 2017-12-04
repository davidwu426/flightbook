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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getOneWayFlights(@RequestParam("dayWeek") String dayWeek) {

        List<SearchEntry> flights = search.getOneWayResults(dayWeek);

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
