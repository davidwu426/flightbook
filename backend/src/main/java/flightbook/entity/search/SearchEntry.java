package flightbook.entity.search;

import flightbook.entity.leg.TripLeg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchEntry {
    private String airlineId;
    private String airlineName;
    private double price;
    private int fromFlightNo;
    private String flightClass;

    private List<TripLeg> tripLegs;

	private Date tripDepTime;
	private Date tripArrTime;
}
