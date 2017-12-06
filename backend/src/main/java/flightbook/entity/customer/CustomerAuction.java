package flightbook.entity.customer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAuction {
    private int accountNo;
    private String airlineId;
    private int flightNo;
    private String flightClass;
    private Date date;
    private int price;
}
