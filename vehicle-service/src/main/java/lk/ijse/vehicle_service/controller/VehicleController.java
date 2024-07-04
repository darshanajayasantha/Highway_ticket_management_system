package lk.ijse.vehicle_service.controller;

import lk.ijse.vehicle_service.dto.VehicleDto;
import lk.ijse.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/health")
    public String healthChech(){
        return "vehicle HealthCheck success";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VehicleDto vehicleDto) {
        vehicleService.saveVehicle(vehicleDto);
        return ResponseEntity.ok("Vehicle saved successfully");

//        if (vehicleService.isExistsUser(vehicleDto.getUserId())) {
//            vehicleService.saveVehicle(vehicleDto);
//            return ResponseEntity.ok("Vehicle saved successfully");
//        }else {
//            return ResponseEntity.ok("User does not exists");
//        }
    }

    @GetMapping("/getAllVehicles")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PutMapping("/updateVehicle")
    public ResponseEntity<?> update(@RequestBody VehicleDto vehicleDto) {
        vehicleService.saveVehicle(vehicleDto);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @GetMapping("/existVehicle/{vehicleId}")
    public ResponseEntity<?> existVehicle(@PathVariable String vehicleId) {
        if (vehicleService.isExistsVehicle(vehicleId)){
            return ResponseEntity.ok("Vehicle exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle does not exist");
        }
    }
}
