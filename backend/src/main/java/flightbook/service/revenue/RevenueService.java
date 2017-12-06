package flightbook.service.revenue;

import flightbook.dao.reservation.IReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService implements  IRevenueService{

    @Autowired
    IReservationDao reservationDao;

    @Override
    public double getReservationByMonth(int month,int year) {
        return reservationDao.getReservationByMonth(month,year).get(0).getBookingFee();
    }

    @Override
    public double getRevenueByFlight(String airlineId, int flightNo) {
        return reservationDao.getRevenueByFlight(airlineId, flightNo);
    }

    @Override
    public double getRevenueByCity(String city) {
        return reservationDao.getRevenueByCity(city);
    }

    @Override
    public double getRevenueByAccountNo(int accountNo) {
        return reservationDao.getRevenueByAccountNo(accountNo);
    }
}
