package iut.montreuil.BoManagementMS.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BoManagementMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoManagementMsApplication.class, args);
	}

}
