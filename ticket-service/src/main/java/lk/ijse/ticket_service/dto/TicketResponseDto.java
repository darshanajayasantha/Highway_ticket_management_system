package lk.ijse.ticket_service.dto;

import lk.ijse.ticket_service.Enum.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketResponseDto {
    private String ticketId;
    private String vehicleId;
    private String userId;
    private Date date;
    private TicketStatus status;
}
