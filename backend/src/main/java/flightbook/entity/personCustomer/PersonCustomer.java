package flightbook.entity.personCustomer;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonCustomer {
    int id;
    String firstName;
    String lastName;
    String telephone;
    String address;
    String city;
    String state;
    int zipCode;
    int accountNo;
    String creditCardNo;
    String email;
    Date date;
    int rating;
    double bookingFee;
}
