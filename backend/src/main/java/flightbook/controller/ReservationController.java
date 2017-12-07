package flightbook.controller;

import flightbook.entity.include.Include;
import flightbook.entity.reservation.BookRequest;
import flightbook.entity.reservation.Reservation;
import flightbook.entity.reservation.ReservationDetails;
import flightbook.service.reservation.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	@Autowired
	private IReservationService reservationService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDetails>> getAllReservations() {
		List<ReservationDetails> reservationDetails = reservationService.getAllReservations();

		return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{resrNo}")
	public ResponseEntity<ReservationDetails> getReservationByNo(@PathVariable int resrNo) {
		ReservationDetails reservationDetails = reservationService.getReservationByNo(resrNo);

		return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = {"airlineId", "flightNo"})
	public ResponseEntity<List<ReservationDetails>> getReservationsByFlight(@RequestParam("airlineId") String airlineId,
	                                                                        @RequestParam("flightNo") int flightNo) {
		List<ReservationDetails> reservationDetails = reservationService.getReservationsByFlight(airlineId, flightNo);

		return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = "accountNo")
	public ResponseEntity<List<ReservationDetails>> getReservationsByAccountNo(@RequestParam("accountNo") int accountNo) {
		List<ReservationDetails> reservationDetails = reservationService.getReservationsByAccountNo(accountNo);

		return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = {"firstName", "lastName"})
	public ResponseEntity<List<ReservationDetails>> getReservationsByCustomerName(@RequestParam("firstName") String firstName,
	                                                                       @RequestParam("lastName") String lastName) {
		List<ReservationDetails> reservationDetails = reservationService.getReservationsByCustomerName(firstName, lastName);

		return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ReservationDetails> createReservation(@RequestBody Reservation reservation,
	                                                            @RequestBody List<Include> includes) {
		ReservationDetails reservationDetails = new ReservationDetails(reservation, includes);

		try {
			reservationService.insertReservation(reservation, includes);

			return new ResponseEntity<>(reservationDetails, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{resrNo}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable int resrNo) {
		try {
			reservationService.deleteReservation(resrNo);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value="/book/oneway")
	public ResponseEntity<Boolean> bookOneWay(@RequestBody BookRequest bookRequest) {
		return new ResponseEntity<>(reservationService.bookOneWay(bookRequest), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value="/book/multiple")
	public ResponseEntity<Boolean> bookRoundTrip(@RequestBody List<BookRequest> bookRequests) {
		return new ResponseEntity<>(reservationService.bookMultiple(bookRequests), HttpStatus.OK);
	}
}
