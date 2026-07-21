package com.rogerio.one_to_one_profile.service;

import com.rogerio.one_to_one_profile.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Transactional
  public void deleteEmployee(Long employeeId) {
    employeeRepository.deleteById(employeeId);
  }
}
