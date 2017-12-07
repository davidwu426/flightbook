package flightbook.service.reservation;

import flightbook.Role;
import flightbook.entity.include.Include;
import flightbook.entity.reservation.BookRequest;
import flightbook.entity.reservation.Reservation;
import flightbook.entity.reservation.ReservationDetails;
import flightbook.entity.reservationpassenger.ReservationPassenger;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IReservationService {
	/**
	 * Get all reservations
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<ReservationDetails> getAllReservations();

	/**
	 * Get reservation by reservation number
	 *
	 * @param resrNo    Reservation number
	 * @return  Reservation with specified reservation number
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	ReservationDetails getReservationByNo(int resrNo);

	/**
	 * Get reservations for a given flight
	 *
	 * @param airlineId Airline Id to get reservations for
	 * @param flightNo  Flight number to get reservations for
	 * @return  Reservations of a given flight
	 */
	@Secured({Role.MANAGER, Role.ADMIN})
	List<ReservationDetails> getReservationsByFlight(String airlineId, int flightNo);

	/**
	 * Get reservations by account number
	 *
	 * @param accountNo Account number of account to get reservations for
	 * @return  Reservations for a given account
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<ReservationDetails> getReservationsByAccountNo(int accountNo);

	/**
	 * Get reservations by customer name
	 *
	 * @param firstName First name of customer
	 * @param lastName  Last name of customer
	 * @return  Reservations for a given customer
	 */
	@Secured({Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	List<ReservationDetails> getReservationsByCustomerName(String firstName, String lastName);

	/**
	 * Inserts an reservation
	 *
	 * @param reservation   Reservation to insert
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void insertReservation(Reservation reservation, List<Include> includes);

	/**
	 * Deletes an reservation given an ID
	 *
	 * @param resrNo    Reservation number of reservation to delete
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	void deleteReservation(int resrNo);

	/**
	 * Book oneway flight
	 *
	 * @return	True if successful, false otherwise
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	boolean bookOneWay(BookRequest b);

	/**
	 * Book multiple flights
	 *
	 * @param b	List of flights to book
	 * @return True if successful, false otherwise
	 */
	@Secured({Role.CUSTOMER, Role.EMPLOYEE, Role.MANAGER, Role.ADMIN})
	boolean bookMultiple(List<BookRequest> b);
}
