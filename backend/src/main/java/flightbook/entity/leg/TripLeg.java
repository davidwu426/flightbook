package flightbook.entity.leg;

import lombok.Data;

@Data
public class TripLeg {
	private Leg leg;

	private long flightDuration;
	private long layoverTime;
}
