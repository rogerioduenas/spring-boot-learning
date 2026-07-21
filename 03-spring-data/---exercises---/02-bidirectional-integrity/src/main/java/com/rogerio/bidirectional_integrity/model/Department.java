package com.rogerio.bidirectional_integrity.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

  @Id
  @GeneratedValue(generator = "gen_dep", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_dep", sequenceName = "seq_dep", allocationSize = 1)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee> employees = new ArrayList<>();;

  public Department() {
  }

  public Department(String name) {
    this.name = name;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.setDepartment(this);
  }

  public Long getId() {
    return id;
  }
}
