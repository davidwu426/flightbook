package flightbook.controller;

import flightbook.entity.customer.CustomerOnFlight;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FrequentFlight;
import flightbook.entity.leg.Leg;
import flightbook.service.flight.IFlightService;
import flightbook.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
	@Autowired
	private IFlightService flightService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> flights = flightService.getAllFlights();

		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{airlineId}")
	public ResponseEntity<List<Flight>> getFlightsByAirline(@PathVariable String airlineId) {
		List<Flight> flights = flightService.getFlightsByAirline(airlineId);

		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{airlineId}/{flightNo}")
	public ResponseEntity<Flight> getFlight(@PathVariable String airlineId, @PathVariable int flightNo) {
		Flight flight = flightService.getFlight(airlineId, flightNo);
		if (flight == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(flight, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/legs")
	public ResponseEntity<List<Leg>> getAllLegs() {
		List<Leg> legs = flightService.getAllLegs();

		return new ResponseEntity<List<Leg>>(legs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{airlineId}/legs")
	public ResponseEntity<List<Leg>> getLegsByAirline(@PathVariable String airlineId) {
		List<Leg> legs = flightService.getLegsByAirline(airlineId);

		return new ResponseEntity<List<Leg>>(legs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{airlineId}/{flightNo}/legs")
	public ResponseEntity<List<Leg>> getLegsByFlightNo(@PathVariable String airlineId, @PathVariable int flightNo) {
		List<Leg> legs = flightService.getLegsByFlight(airlineId, flightNo);

		return new ResponseEntity<List<Leg>>(legs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{airlineId}/{flightNo}/legs/{legNo}")
	public ResponseEntity<Leg> getLeg(@PathVariable String airlineId, @PathVariable int flightNo, @PathVariable int legNo) {
		Leg legs = flightService.getLeg(airlineId, flightNo, legNo);

		return new ResponseEntity<Leg>(legs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/frequent")
	public ResponseEntity<List<FrequentFlight>> getFrequentFlight()
	{
		List<FrequentFlight> frequentFlights = flightService.getFrequentFlight();

		return new ResponseEntity<List<FrequentFlight>>(frequentFlights, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customeronflight")
	public ResponseEntity<List<CustomerOnFlight>> getCustomerOnFlight(@PathVariable String airlineId, @PathVariable int flightNo)
	{
		List<CustomerOnFlight> customerOnFlight = flightService.getCustomerOnFlight(airlineId, flightNo);

		return new ResponseEntity<List<CustomerOnFlight>>(customerOnFlight, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value ="/delayed")
	public ResponseEntity<List<Flight>> getDelayedFlights()
	{
		List<Flight> delayedFlights = flightService.getDelayedFlights();

		return new ResponseEntity<List<Flight>>(delayedFlights, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
		try {
			flightService.insertFlight(flight);

			return new ResponseEntity<>(flight, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/legs")
	public ResponseEntity<Leg> createLeg(@RequestBody Leg leg) {
		try {
			flightService.insertLeg(leg);

			return new ResponseEntity<>(leg, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{airlineId}/{flightNo}")
	public ResponseEntity<Flight> updateFlight(@PathVariable String airlineId, @PathVariable int flightNo, @RequestBody Flight flight) {
		flight.setAirlineId(airlineId);
		flight.setFlightNo(flightNo);

		try {
			flightService.updateFlight(flight);

			return new ResponseEntity<>(flight, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping(method=RequestMethod.PUT, value = "/{airlineId}/{flightNo}/legs/{legNo}")
	public ResponseEntity<Leg> updateLeg(@PathVariable String airlineId, @PathVariable int flightNo,
	                                     @PathVariable int legNo, @RequestBody Leg leg) {
		leg.setAirlineId(airlineId);
		leg.setFlightNo(flightNo);
		leg.setLegNo(legNo);

		try {
			flightService.updateLeg(leg);

			return new ResponseEntity<>(leg, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{airlineId}/{flightNo}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable String airlineId, @PathVariable int flightNo) {
		try {
			flightService.deleteFlight(airlineId, flightNo);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{airlineId}/{flightNo}/legs/{legNo}")
	public ResponseEntity<Flight> deleteLeg(@PathVariable String airlineId, @PathVariable int flightNo, @PathVariable int legNo) {
		try {
			flightService.deleteLeg(airlineId, flightNo, legNo);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
