package flightbook.dao.reservation;

import flightbook.entity.reservation.Reservation;

import java.util.List;

public interface IReservationDao {
	List<Reservation> getAllReservations();

	Reservation getReservationByNo(int resrNo);

	List<Reservation> getReservationsByFlight(String airlineId, int flightNo);

	List<Reservation> getReservationsByAccountNo(int accountNo);

	List<Reservation> getReservationsByCustomerName(String firstName, String lastName);

	void insertReservation(Reservation reservation);

	void deleteReservation(int resrNo);
}
