package flightbook.entity.include;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Include {
	private int resrNo;
	private String airlineId;
	private int flightNo;
	private int legNo;
	private int fromLegNo;
	private Date date;
}
