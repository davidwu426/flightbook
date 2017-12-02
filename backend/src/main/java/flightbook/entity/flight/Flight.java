package flightbook.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight {
	private String airlineId;
	private int flightNo;
	private int noOfSeats;
	private String DaysOperating;
	private int minLengthOfStay;
	private int maxLengthOfStay;
	private boolean isDelayed;
}
