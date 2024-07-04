package lk.ijse.ticket_service.controller;

import lk.ijse.ticket_service.Enum.TicketStatus;
import lk.ijse.ticket_service.dto.TicketDto;
import lk.ijse.ticket_service.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Ticket healthcheck success";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> IssueTicket(@RequestBody TicketDto ticketDto){

        ticketService.issueTicket(ticketDto);
        return ResponseEntity.ok("Ticket booked successfully") ;

//        ticketDto.setStatus(TicketStatus.UNPAID);
//        if(ticketService.isExistsUser)

    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PutMapping("/updateStatus/{ticketId}")
    public ResponseEntity<?> updateStatus(@PathVariable String ticketId) {
        ticketService.updateStatus(ticketId);
        return ResponseEntity.ok("Ticket Status updated successfully");
    }

    @GetMapping("/existTicket/{ticketId}")
    public ResponseEntity<?> existTicket(@PathVariable String ticketId) {
        if (ticketService.isExistsTicket(ticketId)){
            return ResponseEntity.ok("Ticket exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket does not exist");
        }
    }



}
