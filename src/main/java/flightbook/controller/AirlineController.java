package flightbook.controller;

import flightbook.model.Airline;
import flightbook.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	@Autowired
	private IAirlineService airlineService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Airline> getAllAirlines() {
		return airlineService.getAllAirlines();
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Airline getAirline(@PathVariable String id) {
		return airlineService.getAirlineById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Airline addAirline(@RequestBody Airline airline) {
		airlineService.insertAirline(airline);

		return airline;
	}
}
