package com.rogerio.unique_constraints.service;

import com.rogerio.unique_constraints.model.Employee;
import com.rogerio.unique_constraints.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Transactional
  public void registerEmployee(String firstName, String lastName, String taxId) {
    employeeRepository.save(new Employee(firstName, lastName, taxId));
  }
}
