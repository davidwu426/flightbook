package flightbook.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {
	private int id;
	private int SSN;
	private boolean isManager;
	private Date startDate;
	private double hourlyRate;
}
