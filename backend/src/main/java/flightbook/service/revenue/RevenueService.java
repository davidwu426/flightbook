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
}
