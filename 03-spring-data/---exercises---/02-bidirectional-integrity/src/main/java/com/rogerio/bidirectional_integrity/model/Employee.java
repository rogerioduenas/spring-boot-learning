package com.rogerio.bidirectional_integrity.model;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(generator = "gen_emp", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_emp", sequenceName = "seq_emp", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
