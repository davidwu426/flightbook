package flightbook.entity.reservation;

import flightbook.entity.leg.TripLeg;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookRequest {
    private int accountNo;
	private double totalFare;
	private double bookingFee;
    private String flightClass;
    private String meal;
    private String seatNo;
	private List<TripLeg> legs;
	private int fromLegNo;
}
