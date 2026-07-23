package com.rogerio.soft_delete;

import com.rogerio.soft_delete.model.Customer;
import com.rogerio.soft_delete.repository.CustomerRepository;
import com.rogerio.soft_delete.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final CustomerRepository customerRepository;
  private final CustomerService customerService;

  public ExerciseRunner(CustomerRepository customerRepository, CustomerService customerService) {
    this.customerRepository = customerRepository;
    this.customerService = customerService;
  }

  @Override
  public void run(String... args) throws Exception {
  Customer customer = customerRepository.save(new Customer("Mike"));

  customerService.removeCustomer(customer.getId());

  customerService.getAllActiveCustomers()
      .forEach(System.out::println);
  }
}
