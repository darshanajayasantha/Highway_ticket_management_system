package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.Enum.TicketStatus;
import lk.ijse.ticket_service.dto.TicketDto;
import lk.ijse.ticket_service.dto.TicketResponseDto;
import lk.ijse.ticket_service.entity.Ticket;
import lk.ijse.ticket_service.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {
    private final TicketRepository ticketRepository;
    public void issueTicket(TicketDto ticketDto) {

        Ticket ticket = Ticket.builder()
                .vehicleId(ticketDto.getVehicleId())
                .userId(ticketDto.getUserId())
                .date(ticketDto.getDate())
                .status(ticketDto.getStatus())
                .build();

        ticketRepository.save(ticket);


    }

    public List<TicketResponseDto> getAll() {
        return ticketRepository.findAll().stream()
                .map(this::mapToTicketDto).toList();
    }

    private <R> TicketResponseDto mapToTicketDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .ticketId(ticket.getTicketId())
                .vehicleId(ticket.getVehicleId())
                .userId(ticket.getUserId())
                .date(ticket.getDate())
                .status(ticket.getStatus())
                .build();
    }

    public void updateStatus(String ticketId) {
        Optional<Ticket> byId = ticketRepository.findById(ticketId);
        if(byId.isPresent()){
            Ticket ticket = byId.get();
            ticket.setStatus(TicketStatus.PAID);
            ticketRepository.save(ticket);
        }
    }

    public boolean isExistsTicket(String ticketId) {
        return ticketRepository.existsById(ticketId);
    }
}
