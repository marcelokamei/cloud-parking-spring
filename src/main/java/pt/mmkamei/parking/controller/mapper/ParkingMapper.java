package pt.mmkamei.parking.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pt.mmkamei.parking.dto.ParkingDTO;
import pt.mmkamei.parking.model.Parking;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO parkingDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::parkingDTO).collect(Collectors.toList());
    }
}
