package com.rogerio.department_assignment.service;

import com.rogerio.department_assignment.exception.DepartmentNotFoundException;
import com.rogerio.department_assignment.model.Department;
import com.rogerio.department_assignment.model.Employee;
import com.rogerio.department_assignment.repository.DepartmentRepository;
import com.rogerio.department_assignment.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  public EmployeeService(EmployeeRepository employeeRepository,
                         DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  @Transactional
  public Employee save(String name, Long departmentId) {
    Department department = departmentRepository
        .findById(departmentId)
        .orElseThrow(() -> new DepartmentNotFoundException("Department with id %s not found".formatted(departmentId)));
    Employee employee = new Employee(name, department);
    employeeRepository.save(employee);
    return employee;
  }
}
