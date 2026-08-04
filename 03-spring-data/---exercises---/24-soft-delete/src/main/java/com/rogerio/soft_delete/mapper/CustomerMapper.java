package com.rogerio.soft_delete.mapper;

import com.rogerio.soft_delete.dto.CustomerResponseDTO;
import com.rogerio.soft_delete.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

  public CustomerResponseDTO toDto(Customer customer) {
    return new CustomerResponseDTO(
        customer.getId(),
        customer.getName()
    );
  }
}
