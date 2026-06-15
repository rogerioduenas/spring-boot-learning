package com.rogerio.ticket_management.service;

import com.rogerio.ticket_management.dto.TicketRequestDTO;
import com.rogerio.ticket_management.dto.TicketResponseDTO;
import com.rogerio.ticket_management.exception.TicketLimitExceededException;
import com.rogerio.ticket_management.exception.TicketNotFoundException;
import com.rogerio.ticket_management.mapper.TicketMapper;
import com.rogerio.ticket_management.model.Ticket;
import com.rogerio.ticket_management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper ticketMapper;
  private final int ticketLimit;

  public TicketService(
      TicketRepository ticketRepository,
      TicketMapper ticketMapper,
      @Value("${app.ticket.limit}") int ticketLimit) {
    this.ticketRepository = ticketRepository;
    this.ticketMapper = ticketMapper;
    this.ticketLimit = ticketLimit;
  }

  public TicketResponseDTO create(TicketRequestDTO dto) {
    if (ticketRepository.size() >= ticketLimit) {
      throw new TicketLimitExceededException("Too many tickets");
    }
    Ticket ticket = ticketMapper.toEntity(dto);
    Ticket savedTicket = ticketRepository.save(ticket);
    TicketResponseDTO responseDTO = ticketMapper.toDTO(savedTicket);
    return responseDTO;
  }

  public List<TicketResponseDTO> findAll(int page, int size) {
    List<Ticket> allTickets = ticketRepository.findAll();
    int start = (page - 1) * size;
    if (start >= allTickets.size()) {
      return List.of();
    }
    int end = Math.min(start + size, allTickets.size());
    List<Ticket> ticketList = allTickets.subList(start, end);
    return ticketList.stream()
        .map(ticketMapper::toDTO)
        .toList();
  }

  public TicketResponseDTO close(Long id) {
    Ticket ticket = ticketRepository.findById(id)
        .orElseThrow(() -> new TicketNotFoundException("Ticket not found"));
    ticket.setIsClosed(true);
    ticketRepository.save(ticket);
    return ticketMapper.toDTO(ticket);
  }
}
