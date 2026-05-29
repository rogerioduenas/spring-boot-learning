package com.rogerio.employee_registration.repository;

import com.rogerio.employee_registration.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

  private final List<Employee> employees = new ArrayList<>();
  private Long nextId = 1L;

  public Employee save(final Employee employee) {
    employee.setId(nextId);
    nextId++;
    employees.add(employee);
    return employee;
  }
}
