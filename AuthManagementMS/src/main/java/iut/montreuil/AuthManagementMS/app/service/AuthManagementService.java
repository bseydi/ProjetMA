package iut.montreuil.AuthManagementMS.app.service;

import org.springframework.stereotype.Service;

@Service
public class AuthManagementService {

	private static final String NORMAL_USER_USERNAME = "user";
    private static final String NORMAL_USER_PASSWORD = "password";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminpassword";
    
    public String authenticate(String username, String password) {
        if (username.equals(NORMAL_USER_USERNAME) && password.equals(NORMAL_USER_PASSWORD)) {
            return "jwt-token-for-normal-user";
        } else if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return "jwt-token-for-admin";
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}
