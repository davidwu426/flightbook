package flightbook.entity.reservation;

import flightbook.entity.include.Include;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ReservationDetails {
	private int resrNo;
	private Date resrDate;
	private double bookingFee;
	private double totalFare;
	private int repSSN;
	private int accountNo;
	private List<Include> includes;

	public ReservationDetails(Reservation r, List<Include> includes) {
		this.resrNo = r.getResrNo();
		this.resrDate = r.getResrDate();
		this.bookingFee = r.getBookingFee();
		this.totalFare = r.getTotalFare();
		this.repSSN = r.getRepSSN();
		this.accountNo = r.getAccountNo();
		this.includes = includes;
	}
}
