package com.rogerio.pagination;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String role;
  private Double salary;

  public Employee() {
  }

  public Employee(String name, String role, Double salary) {
    this.name = name;
    this.role = role;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return String.format("%d - %s - %s - %s%n", id, name, role, salary);
  }
}
