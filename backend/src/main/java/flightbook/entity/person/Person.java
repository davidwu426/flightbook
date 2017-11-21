package flightbook.entity.person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String telephone;
	private String address;
	private String city;
	private String state;
	private int zip;
}
