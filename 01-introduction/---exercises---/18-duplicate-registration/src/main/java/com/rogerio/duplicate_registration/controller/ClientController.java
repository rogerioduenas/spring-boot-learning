package com.rogerio.duplicate_registration.controller;

import com.rogerio.duplicate_registration.dto.ClientResponseDTO;
import com.rogerio.duplicate_registration.dto.CreateClientRequestDTO;
import com.rogerio.duplicate_registration.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<ClientResponseDTO> create(@RequestBody CreateClientRequestDTO request) {
    ClientResponseDTO response = clientService.createClient(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
