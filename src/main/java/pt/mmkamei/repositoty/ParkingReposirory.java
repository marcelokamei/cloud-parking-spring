package pt.mmkamei.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.mmkamei.parking.model.Parking;

//@Repository
public interface ParkingReposirory extends JpaRepository<Parking, String> {

}
