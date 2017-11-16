package flightbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    @Bean
	public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurerAdapter() {
		    @Override
		    public void addCorsMappings(CorsRegistry registry) {
			    registry.addMapping("/api/**")
					    .allowedMethods("*")
					    .allowedOrigins("http://localhost:4200");
		    }
	    };
    }
}
