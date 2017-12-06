package flightbook.entity.flightreservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightReservation {
    private String airlineId;
    private int flightNo;
    private int resrCount;
}
