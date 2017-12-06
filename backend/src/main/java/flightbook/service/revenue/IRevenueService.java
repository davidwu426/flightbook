package flightbook.service.revenue;

import flightbook.Role;
import org.springframework.security.access.annotation.Secured;

public interface IRevenueService {
    @Secured({ Role.MANAGER, Role.ADMIN})
    double getReservationByMonth(int month, int year);

    @Secured({ Role.MANAGER, Role.ADMIN })
    double getRevenueByFlight(String airlineId, int flightNo);

    @Secured({ Role.MANAGER, Role.ADMIN })
    double getRevenueByCity(String city);

    @Secured({ Role.MANAGER, Role.ADMIN })
    double getRevenueByAccountNo(int accountNo);
}
