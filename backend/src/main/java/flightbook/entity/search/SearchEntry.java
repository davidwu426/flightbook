package flightbook.entity.search;

import flightbook.entity.leg.Leg;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class SearchEntry {
    private String airlineId;
    private double price;
    private int fromFlightNo;

    private List<Leg> legs;
}
