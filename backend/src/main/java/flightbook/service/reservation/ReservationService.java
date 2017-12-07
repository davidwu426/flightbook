package flightbook.service.reservation;

import flightbook.dao.reservation.IReservationDao;
import flightbook.dao.include.IIncludeDao;
import flightbook.dao.reservationpassenger.IReservationPassengerDao;
import flightbook.entity.include.Include;
import flightbook.entity.reservation.BookRequest;
import flightbook.entity.reservation.Reservation;
import flightbook.entity.reservation.ReservationDetails;
import flightbook.entity.reservationpassenger.ReservationPassenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
	@Autowired
	IReservationDao reservationDao;
	@Autowired
	IIncludeDao includeDao;
	@Autowired
	IReservationPassengerDao reservationPassengerDao;

	@Override
	public List<ReservationDetails> getAllReservations() {
		List<Reservation> reservations = reservationDao.getAllReservations();

		return getReservationDetailsList(reservations);
	}

	@Override
	public ReservationDetails getReservationByNo(int resrNo) {
		Reservation reservation = reservationDao.getReservationByNo(resrNo);

		return getReservationDetails(reservation);
	}

	@Override
	public List<ReservationDetails> getReservationsByFlight(String airlineId, int flightNo) {
		List<Reservation> reservations = reservationDao.getReservationsByFlight(airlineId, flightNo);

		return getReservationDetailsList(reservations);
	}

	@Override
	public List<ReservationDetails> getReservationsByAccountNo(int accountNo) {
		List<Reservation> reservations = reservationDao.getReservationsByAccountNo(accountNo);

		return getReservationDetailsList(reservations);
	}

	@Override
	public List<ReservationDetails> getReservationsByCustomerName(String firstName, String lastName) {
		List<Reservation> reservations = reservationDao.getReservationsByCustomerName(firstName, lastName);

		return getReservationDetailsList(reservations);
	}

	@Override
	@Transactional
	public void insertReservation(Reservation reservation, List<Include> includes) {
		reservationDao.insertReservation(reservation);

		for (Include i: includes) {
			includeDao.insertInclude(i);
		}
	}

	@Override
	public void deleteReservation(int resrNo) {
		reservationDao.deleteReservation(resrNo);
	}

	private ReservationDetails getReservationDetails(Reservation reservation) {
		List<Include> include = includeDao.getIncludesByResrNo(reservation.getResrNo());

		return new ReservationDetails(reservation, include);
	}

	private List<ReservationDetails> getReservationDetailsList(List<Reservation> reservations) {
		List<ReservationDetails> reservationDetails = new ArrayList<>();

		for (Reservation r: reservations) {
			reservationDetails.add(getReservationDetails(r));
		}

		return reservationDetails;
	}

	@Override
	@Transactional
	public boolean bookOneWay(BookRequest b) {
		try {
			insertReservation(b.getReservation(), b.getIncludes());
			reservationPassengerDao.insertReservationPassenger(b.getReservationPassenger());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean bookMultiple(List<BookRequest> bs) {
		try {
			for (BookRequest br : bs) {
				bookOneWay(br);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
