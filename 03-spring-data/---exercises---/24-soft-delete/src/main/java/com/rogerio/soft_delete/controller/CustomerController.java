package com.rogerio.soft_delete.controller;

import com.rogerio.soft_delete.dto.CustomerResponseDTO;
import com.rogerio.soft_delete.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    customerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerResponseDTO>> findAll() {
    List<CustomerResponseDTO> customers = customerService.findAll();
    return ResponseEntity.ok(customers);
  }
}
