package flightbook;

import flightbook.entity.Airline;
import flightbook.dao.AirlineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	    AirlineDao dao = new AirlineDao(jdbcTemplate);

	    Airline a = dao.getAirlineById("B6");
	    System.out.println("found airline: " + a.getName());
    }
}
