package flightbook.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Customer {
	private int id;
	private int accountNo;
	private String creditCardNo;
	private String email;
	private Date creationDate;
	private int rating;
}