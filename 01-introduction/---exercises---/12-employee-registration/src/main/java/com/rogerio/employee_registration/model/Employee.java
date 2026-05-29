package com.rogerio.employee_registration.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
  private Long id;
  private final String name;
  private Role role;
  private Double salary;

  public Employee(String name, Role role, Double salary) {
    this.name = name;
    this.role = role;
    this.salary = salary;
  }
}