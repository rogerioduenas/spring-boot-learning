package com.rogerio.department_assignment.model;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen", sequenceName = "seq_emp", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  public Employee() {
  }

  public Employee(String name, Department department) {
    this.name = name;
    this.department = department;
  }
}
