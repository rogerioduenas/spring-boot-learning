package com.rogerio.soft_delete.config;

import com.rogerio.soft_delete.model.Customer;
import com.rogerio.soft_delete.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final CustomerRepository customerRepository;

  public DatabaseSeeder(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Customer> customers = List.of(
        new Customer("Mike"),
        new Customer("Anna"),
        new Customer("Bob")
    );
    if (customerRepository.count() == 0) {
      customerRepository.saveAll(customers);
    }
  }
}
