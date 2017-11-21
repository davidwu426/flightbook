package flightbook.controller;

import flightbook.entity.airline.Airline;
import flightbook.service.airline.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {
	@Autowired
	private IAirlineService airlineService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Airline>> getAllAirlines() {
		List<Airline> airlines = airlineService.getAllAirlines();

		return new ResponseEntity<>(airlines, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Airline> getAirline(@PathVariable String id) {
		Airline airline = airlineService.getAirlineById(id);
		if (airline == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(airline, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Airline> updateAirline(@PathVariable String id, @RequestBody Airline airline) {
		Airline currentAirline = airlineService.getAirlineById(id);
		if (currentAirline == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		currentAirline.setName(airline.getName());

		airlineService.updateAirline(currentAirline);
		return new ResponseEntity<Airline>(currentAirline, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
		try {
			airlineService.insertAirline(airline);

			return new ResponseEntity<>(airline, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Airline> deleteAirline(@PathVariable String id) {
		try {
			airlineService.deleteAirline(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
