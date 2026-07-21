package com.rogerio.one_to_one_profile.model;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(generator = "gen_emp", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_emp", sequenceName = "seq_emp", allocationSize = 1)
  private Long id;

  private String name;

  @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
  EmployeeProfile employeeProfile;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setEmployeeProfile(EmployeeProfile employeeProfile) {
    this.employeeProfile = employeeProfile;
  }
}
