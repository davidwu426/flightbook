package flightbook.entity.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	private String fromAirport;
	private String toAirport;
	private Date departureDate;
	private Date returningDate;
}
