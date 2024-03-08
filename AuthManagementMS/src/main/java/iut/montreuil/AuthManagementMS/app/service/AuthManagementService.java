package iut.montreuil.AuthManagementMS.app.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

@Service
public class AuthManagementService {

	private static final String NORMAL_USER_USERNAME = "user";
    private static final String NORMAL_USER_PASSWORD = "password";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminpassword";
    
    public String authenticate(String username, String password) {
    	byte[] toEncode = (username + ":" + password).getBytes();
    	String token = "Basic " + Base64.getEncoder().encodeToString(toEncode);
    	
        if (username.equals(NORMAL_USER_USERNAME) && password.equals(NORMAL_USER_PASSWORD)) {
            return token;
        } else if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return token;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}
