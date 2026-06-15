package com.rogerio.ticket_management.controller;

import com.rogerio.ticket_management.dto.TicketRequestDTO;
import com.rogerio.ticket_management.dto.TicketResponseDTO;
import com.rogerio.ticket_management.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping
  public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketRequestDTO dto) {
    TicketResponseDTO responseDTO = ticketService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @GetMapping
  public ResponseEntity<List<TicketResponseDTO>> getAllTickets(@RequestParam int page, @RequestParam int size) {
    List<TicketResponseDTO> responseDtos = ticketService.findAll(page, size);
    return ResponseEntity.ok(responseDtos);
  }

  @PatchMapping("/{id}/close")
  public ResponseEntity<TicketResponseDTO> closeTicket(@PathVariable Long id) {
    TicketResponseDTO responseDTO = ticketService.close(id);
    return ResponseEntity.ok(responseDTO);
  }
}
