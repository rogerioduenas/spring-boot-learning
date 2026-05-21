package com.rogerio.customer_locator.controller;

import com.rogerio.customer_locator.dto.CustomerResponseDTO;
import com.rogerio.customer_locator.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  List<Customer> customers = new ArrayList<>(List.of(
      new Customer(1L, "Mike", "mike@mike.com"),
      new Customer(2L, "Anna", "anna@anna.com"),
      new Customer(3L, "Caio", "caio@caio.com")
  ));

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
    return customers.stream()
        .filter(customer -> customer.id().equals(id))
        .findFirst()
        .map(customer -> new CustomerResponseDTO(customer.id(), customer.name(), customer.email()))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
