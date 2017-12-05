package flightbook.controller;

import flightbook.entity.airport.Airport;
import flightbook.entity.flight.Flight;
import flightbook.service.airport.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
	@Autowired
	private IAirportService airportService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Airport>> getAllAirports() {
		List<Airport> airports = airportService.getAllAirports();

		return new ResponseEntity<>(airports, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Airport> getAirport(@PathVariable String id) {
		Airport airport = airportService.getAirportById(id);
		if (airport == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(airport, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
		try {
			airportService.insertAirport(airport);

			return new ResponseEntity<>(airport, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable String id, @RequestBody Airport airport) {
		Airport currentAirport = airportService.getAirportById(id);
		if (currentAirport == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		currentAirport.setName(airport.getName());
		currentAirport.setCity(airport.getCity());
		currentAirport.setCountry(airport.getCountry());

		airportService.updateAirport(currentAirport);
		return new ResponseEntity<>(currentAirport, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Airport> deleteAirport(@PathVariable String id) {
		try {
			airportService.deleteAirport(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
