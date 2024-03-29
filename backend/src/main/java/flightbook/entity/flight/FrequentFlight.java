package flightbook.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrequentFlight {
    private String airlineId;
    private int flightNo;
    private int count;
}
