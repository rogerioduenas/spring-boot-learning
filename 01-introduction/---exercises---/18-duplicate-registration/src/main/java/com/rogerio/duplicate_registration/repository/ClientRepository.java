package com.rogerio.duplicate_registration.repository;

import com.rogerio.duplicate_registration.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {

  private static final List<Client> clientsTable = new ArrayList<>();
  private static Long idCounter = 1L;

  public boolean existsByEmail(String email) {
    return clientsTable.stream()
        .anyMatch(client -> client.getEmail().equalsIgnoreCase(email));
  }

  public Client save(Client client) {
    client.setId(idCounter++);
    clientsTable.add(client);
    return client;
  }
}
