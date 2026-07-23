package com.rogerio.soft_delete.service;

import com.rogerio.soft_delete.model.Customer;
import com.rogerio.soft_delete.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Transactional
  public void removeCustomer(Long id){
    customerRepository.deleteById(id);
  }

  public List<Customer> getAllActiveCustomers(){
    return customerRepository.findAll();
  }
}
