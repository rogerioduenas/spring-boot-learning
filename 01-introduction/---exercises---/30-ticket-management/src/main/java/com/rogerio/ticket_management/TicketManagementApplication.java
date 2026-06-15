package com.rogerio.ticket_management;

import com.rogerio.ticket_management.model.Priority;
import com.rogerio.ticket_management.model.Ticket;
import com.rogerio.ticket_management.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class TicketManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(TicketManagementApplication.class, args);
  }

  @Bean
  public CommandLineRunner seedData(TicketRepository repository) {
    return args -> {
      Ticket t1 = new Ticket(
          "Error accessing the system.",
          "User unable to log in on the home screen.",
          Priority.LOW
      );

      Ticket t2 = new Ticket(
          "Offline printer.",
          "The HR printer is not responding to commands.",
          Priority.MEDIUM
      );
      t2.setIsClosed(true);

      Ticket t3 = new Ticket(
          "Set up VPN.",
          "New employee needs remote access.",
          Priority.HIGH
      );

      repository.save(t1);
      repository.save(t2);
      repository.save(t3);

      System.out.println("🌱 In-memory database seeded with 3 tickets!");
    };
  }
}
