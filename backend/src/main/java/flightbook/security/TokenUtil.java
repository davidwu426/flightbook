package flightbook.security;

import flightbook.service.user.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
class TokenUtil {
	private final String SECRET = "flightbooksecret";
	private final long EXPIRATION_TIME = 864_000_000;
	private final String TOKEN_PREFIX = "Bearer ";
	private final String HEADER_STRING = "Authorization";

	void addAuthentication(HttpServletResponse res, String username) throws IOException {
		String jwt = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();

		res.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
		res.getWriter().write("{\"jwt\": \"" + TOKEN_PREFIX + jwt + "\"}");
		res.getWriter().flush();
		res.getWriter().close();
	}

	Authentication getAuthentication(HttpServletRequest req, IUserService userService) {
		String token = req.getHeader(HEADER_STRING);
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, userService.getGrantedAuthorities(user));
			} else {
				return null;
			}
		}

		return null;
	}
}
