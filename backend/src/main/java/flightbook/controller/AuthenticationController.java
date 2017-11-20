package flightbook.controller;

import flightbook.Role;
import flightbook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {
	@Autowired
	IUserService userService;

	@PreAuthorize("hasAnyRole('" + Role.CUSTOMER + "','"
		+ Role.EMPLOYEE + "','"
		+ Role.MANAGER + "','"
		+ Role.ADMIN + "')"
	)
	@RequestMapping(method = RequestMethod.POST)
//	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login() {
//		return "success";
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
