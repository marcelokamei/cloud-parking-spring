package pt.mmkamei.parking.service;

import org.springframework.stereotype.Service;
import pt.mmkamei.parking.model.Parking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id1 = getUUID();
        var id2 = getUUID();
        var id3 = getUUID();
        Parking parking = new Parking(id1, "KMK-4545", "RO", "Polo", "Amarelo");
        Parking parking1 = new Parking(id2, "KKK-1234", "MS", "Gol", "Preto");
        Parking parking2 = new Parking(id3, "aaa-4567", "PR", "Vectra", "Branco");
        parkingMap.put(id1, parking);
        parkingMap.put(id2, parking1);
        parkingMap.put(id3, parking2);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}