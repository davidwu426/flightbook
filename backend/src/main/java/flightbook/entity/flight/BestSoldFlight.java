package flightbook.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BestSoldFlight {
    private int flightNo;
    private double bookingFee;
    private double totalFare;
}
