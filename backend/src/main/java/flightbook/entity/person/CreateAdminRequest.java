package flightbook.entity.person;

import lombok.Data;

@Data
public class CreateAdminRequest {
	private String username;
	private String password;

	private String firstName;
	private String lastName;
	private String telephone;
	private String address;
	private String city;
	private String state;
	private int zip;
}
