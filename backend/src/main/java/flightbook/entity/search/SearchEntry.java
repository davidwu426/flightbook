package flightbook.entity.search;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SearchEntry {
    private int flightNo;
    private String airlineId;
    private double price;
}
