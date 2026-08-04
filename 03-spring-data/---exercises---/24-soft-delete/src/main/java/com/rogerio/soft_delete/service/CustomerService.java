package com.rogerio.soft_delete.service;

import com.rogerio.soft_delete.dto.CustomerResponseDTO;
import com.rogerio.soft_delete.exception.ResourceNotFoundException;
import com.rogerio.soft_delete.mapper.CustomerMapper;
import com.rogerio.soft_delete.model.Customer;
import com.rogerio.soft_delete.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Transactional
  public void deleteById(Long id) {
    if (!customerRepository.existsById(id)) {
      throw new ResourceNotFoundException(String.format("Customer with id %s not found.", id));
    }
    customerRepository.deleteById(id);
  }

  @Transactional(readOnly = true)
  public List<CustomerResponseDTO> findAll() {
    List<Customer> customers = customerRepository.findAll();

    return customers.stream()
        .map(customerMapper::toDto)
        .toList();
  }
}
