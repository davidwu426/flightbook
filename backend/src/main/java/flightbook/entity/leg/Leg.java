package flightbook.entity.leg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Leg {
	private String airlineId;
	private int flightNo;
	private int legNo;
	private String depAirportId;
	private String arrAirportId;
	private Date arrTime;
	private Date depTime;
}
