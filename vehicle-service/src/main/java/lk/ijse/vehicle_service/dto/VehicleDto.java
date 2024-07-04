package lk.ijse.vehicle_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDto {
    private String vehicleId;
    private String brand;
    private String model;
    private String colour;
    private String userId;
}
