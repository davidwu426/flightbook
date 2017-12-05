package flightbook.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrequentFlight {
    private int flightNo;
    private String airlineId;
    private int count;
}
