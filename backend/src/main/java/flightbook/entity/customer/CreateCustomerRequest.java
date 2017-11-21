package flightbook.entity.customer;

import lombok.Data;

@Data
public class CreateCustomerRequest {
	private String username;
	private String password;

	private String firstName;
	private String lastName;
	private String telephone;
	private String address;
	private String city;
	private String state;
	private int zip;

	private String creditCardNo;
	private String email;
}
