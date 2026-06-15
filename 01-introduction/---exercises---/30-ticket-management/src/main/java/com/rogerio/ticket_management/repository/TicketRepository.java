package com.rogerio.ticket_management.repository;

import com.rogerio.ticket_management.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepository {

  private List<Ticket> tickets = new ArrayList<>();
  private Long idCounter = 1L;

  public List<Ticket> findAll() {
    return tickets;
  }

  public Optional<Ticket> findById(Long id) {
    return tickets.stream()
        .filter(t -> t.getId().equals(id))
        .findFirst();
  }

  public Ticket save(Ticket ticket) {
    if (ticket.getId() == null) {
      ticket.setId(idCounter++);
      tickets.add(ticket);
      return ticket;
    }

    for (int i = 0; i < tickets.size(); i++) {
      if (tickets.get(i).getId().equals(ticket.getId())) {
        tickets.set(i, ticket);
        return ticket;
      }
    }

    return ticket;
  }

  public int size() {
    return tickets.size();
  }
}
