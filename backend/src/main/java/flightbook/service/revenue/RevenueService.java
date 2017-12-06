package flightbook.service.revenue;

import flightbook.dao.customer.ICustomerDao;
import flightbook.dao.reservation.IReservationDao;
import flightbook.entity.personCustomer.PersonCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService implements  IRevenueService{

    @Autowired
    IReservationDao reservationDao;

    @Autowired
    ICustomerDao customerDao;

    @Override
    public double getReservationByMonth(int month,int year) {
        return reservationDao.getReservationByMonth(month,year).get(0).getBookingFee();
    }

    @Override
    public int getBestCustomerRep() {
        return customerDao.getBestCustomerRep();
    }

    @Override
    public PersonCustomer getBestCustomer() {
        return customerDao.getBestCustomer();
    }

}
