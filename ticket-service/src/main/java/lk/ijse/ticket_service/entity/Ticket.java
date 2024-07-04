package lk.ijse.ticket_service.entity;

import jakarta.persistence.*;
import lk.ijse.ticket_service.Enum.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "t-ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;
    private String vehicleId;
    private String userId;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

}
