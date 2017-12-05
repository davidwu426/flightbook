package flightbook.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerOnFlight {

    private int accountNumber;
    private String firtName;
    private String lastName;
    private int reservationNumber;
    private String seatNumber;
    private String seatClass;
    private String meal;

}
