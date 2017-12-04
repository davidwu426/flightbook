package flightbook.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerContact {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private String email;
}
