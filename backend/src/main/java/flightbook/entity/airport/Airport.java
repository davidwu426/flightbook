package flightbook.entity.airport;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Airport {
	private String id;
	private String name;
	private String city;
	private String country;
}
