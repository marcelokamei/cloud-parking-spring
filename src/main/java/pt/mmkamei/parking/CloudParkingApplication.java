package pt.mmkamei.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pt.mmkamei.repositoty.ParkingReposirory;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ParkingReposirory.class)
public class CloudParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
