package iut.montreuil.AuthManagementMS.app.controller;

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

	AuthManagementService authManagementService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		System.out.println("Ok AUTH");
		return "ok";
		//ResponseEntity<String>
//		try {
//			String token = authManagementService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
//			return ResponseEntity.ok(token);
//		} catch (IllegalArgumentException e) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//		}
	}
}