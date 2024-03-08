package iut.montreuil.AuthManagementMS.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iut.montreuil.AuthManagementMS.app.model.LoginRequest;
import iut.montreuil.AuthManagementMS.app.service.AuthManagementService;

@RestController
@RequestMapping("/auth")
public class AuthManagementController {

	@Autowired
	private AuthManagementService authManagementService;
	
	@PostMapping
	@RequestMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		try {
			String token = authManagementService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
			return ResponseEntity.ok(token);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
	}
}