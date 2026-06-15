package com.rogerio.ticket_management.mapper;

import com.rogerio.ticket_management.dto.TicketRequestDTO;
import com.rogerio.ticket_management.dto.TicketResponseDTO;
import com.rogerio.ticket_management.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

  public Ticket toEntity(TicketRequestDTO dto) {
    return new Ticket(dto.title(), dto.description(), dto.priority());
  }

  public TicketResponseDTO toDTO(Ticket entity) {
    return new TicketResponseDTO(
        entity.getId(),
        entity.getTitle(),
        entity.getPriority(),
        entity.getIsClosed() == true ? "CLOSED" : "IN PROGRESS");
  }
}
