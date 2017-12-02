package flightbook.entity.employee;

import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeRequest {
	private String username;
	private String password;

	private String firstName;
	private String lastName;
	private String telephone;
	private String address;
	private String city;
	private String state;
	private int zip;

	private int SSN;
	private Date startDate;
	private double hourlyRate;
}
