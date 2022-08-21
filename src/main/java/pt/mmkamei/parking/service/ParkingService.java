package pt.mmkamei.parking.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.mmkamei.parking.model.Parking;
import pt.mmkamei.parking.model.exception.ParkingNotFoundException;
import pt.mmkamei.repositoty.ParkingReposirory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {


    public final ParkingReposirory parkingReposirory;


    public ParkingService(ParkingReposirory parkingReposirory) {
        this.parkingReposirory = parkingReposirory;
    }

    @Transactional(readOnly = true)
    public List<Parking> findAll(){

        return parkingReposirory.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional(readOnly = true)
    public Parking findById(String id) {
        return parkingReposirory.findById(id).orElseThrow(()-> new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingReposirory.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingReposirory.deleteById(id);

    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());
        parkingReposirory.save(parking);
        return parking;
    }

    @Transactional
    public Parking checkOut(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        return parkingReposirory.save(parking);
    }
}