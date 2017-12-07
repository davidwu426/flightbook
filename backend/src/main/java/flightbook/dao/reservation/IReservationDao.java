package flightbook.dao.reservation;

import flightbook.entity.reservation.Reservation;
import flightbook.entity.totalbookingfee.TotalBookingFee;

import java.util.List;

public interface IReservationDao {
	List<Reservation> getAllReservations();

	Reservation getReservationByNo(int resrNo);

	List<Reservation> getReservationsByFlight(String airlineId, int flightNo);

	List<Reservation> getReservationsByAccountNo(int accountNo);

	List<Reservation> getReservationsByCustomerName(String firstName, String lastName);

	void insertReservation(Reservation reservation);

	void deleteReservation(int resrNo);

	List<TotalBookingFee> getReservationByMonth(int month, int year);

	double getRevenueByFlight(String airlineId, int flightNo);

	double getRevenueByCity(String city);

	double getRevenueByAccountNo(int AccountNo);
}
