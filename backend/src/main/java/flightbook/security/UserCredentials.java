package flightbook.security;

import lombok.Data;

@Data
public class UserCredentials {
	private String username;
	private String password;
}
