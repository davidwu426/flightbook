package flightbook.entity.reservationpassenger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationPassenger {
    private int resrNo;
    private int id;
    private int accountNo;
    private String seatNo;
    private String flightClass;
    private String meal;
}
