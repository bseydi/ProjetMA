package iut.montreuil.AuthManagementMS.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AuthManagementMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthManagementMsApplication.class, args);
	}

}
