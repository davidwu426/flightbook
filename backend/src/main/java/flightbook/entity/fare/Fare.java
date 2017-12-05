package flightbook.entity.fare;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fare {
	private String airlineId;
	private int flightNo;
	private String fareType;
	private String flightClass;
	private double fare;
}
