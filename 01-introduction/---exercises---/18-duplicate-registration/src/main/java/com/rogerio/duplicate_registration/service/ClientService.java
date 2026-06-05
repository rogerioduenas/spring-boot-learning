package com.rogerio.duplicate_registration.service;

import com.rogerio.duplicate_registration.dto.ClientResponseDTO;
import com.rogerio.duplicate_registration.dto.CreateClientRequestDTO;
import com.rogerio.duplicate_registration.exception.EmailDuplicatedException;
import com.rogerio.duplicate_registration.model.Client;
import com.rogerio.duplicate_registration.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClientResponseDTO createClient(CreateClientRequestDTO request) {
    if (clientRepository.existsByEmail(request.email())) {
      throw new EmailDuplicatedException("The email '" + request.email() + "' is already registered.");
    }

    Client client = new Client();
    client.setName(request.name());
    client.setEmail(request.email());

    Client savedClient = clientRepository.save(client);

    return new ClientResponseDTO(savedClient.getId(), savedClient.getName(), savedClient.getEmail());
  }
}
