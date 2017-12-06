package flightbook.service.revenue;

import flightbook.Role;
import flightbook.entity.personCustomer.PersonCustomer;
import org.springframework.security.access.annotation.Secured;

public interface IRevenueService {
    @Secured({ Role.MANAGER, Role.ADMIN})
    double getReservationByMonth(int month, int year);
    int getBestCustomerRep();
    PersonCustomer getBestCustomer();
}
