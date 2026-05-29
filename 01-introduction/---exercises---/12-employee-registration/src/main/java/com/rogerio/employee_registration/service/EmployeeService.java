package com.rogerio.employee_registration.service;

import com.rogerio.employee_registration.dto.CreateEmployeeDTO;
import com.rogerio.employee_registration.dto.ResponseEmployeeDTO;
import com.rogerio.employee_registration.model.Employee;
import com.rogerio.employee_registration.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public ResponseEmployeeDTO saveEmployee(CreateEmployeeDTO createEmployeeDTO) {
    Employee employee = new Employee(createEmployeeDTO.name(), createEmployeeDTO.role(), createEmployeeDTO.salary());
    employeeRepository.save(employee);
    return new ResponseEmployeeDTO(employee.getId(), employee.getName(), employee.getRole());
  }
}
