package com.rogerio.web_mvc.service;

import com.rogerio.web_mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
  List<Employee> getAllEmployees();
  Employee getEmployeeById(Long id);
  Employee createEmployee(Employee employee);
  Employee updateEmployee(Long id, Employee employee);
  void deleteEmployee(Long id);
}
