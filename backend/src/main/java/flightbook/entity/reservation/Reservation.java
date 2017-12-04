package flightbook.entity.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation {
	private int resrNo;
	private Date resrDate;
	private double bookingFee;
	private double totalFare;
	private int reprSSN;
	private int accountNo;
}
