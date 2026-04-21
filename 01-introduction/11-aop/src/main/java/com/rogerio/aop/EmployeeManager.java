package com.rogerio.aop;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

  public Employee getEmployeeById(Integer employeeId) {
    System.out.println("Method getEmployeeById() called");
    return new Employee();
  }
}
