package flightbook.entity.reservation;

import flightbook.entity.include.Include;
import flightbook.entity.reservationpassenger.ReservationPassenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookRequest {
    private ReservationPassenger reservationPassenger;
    private Reservation reservation;
    private List<Include> includes;
}
