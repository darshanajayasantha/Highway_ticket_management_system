package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDto;
import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public void saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = Vehicle.builder()
                .vehicleId(vehicleDto.getVehicleId())
                .brand(vehicleDto.getBrand())
                .model(vehicleDto.getModel())
                .colour(vehicleDto.getColour())
                .userId(vehicleDto.getUserId())
                .build();
        vehicleRepository.save(vehicle);

    }

    public List<VehicleDto> getAll() {
        return vehicleRepository.findAll().stream()
                .map(this::mapToVehicleDto).toList();
    }

    private <R> VehicleDto mapToVehicleDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .vehicleId(vehicle.getVehicleId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .userId(vehicle.getUserId())
                .build();
    }

    public boolean isExistsVehicle(String vehicleId) {
        return vehicleRepository.existsById(vehicleId);
    }


//    public boolean isExistsUser(String userId) {
//    }


}
