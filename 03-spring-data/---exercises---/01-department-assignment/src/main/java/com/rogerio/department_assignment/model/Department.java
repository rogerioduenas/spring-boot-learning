package com.rogerio.department_assignment.model;

import jakarta.persistence.*;

@Entity
public class Department {

  @Id
  @GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen", sequenceName = "seq_dep", allocationSize = 1)
  private Long id;

  private String name;

  public Department() {
  }

  public Department(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
}
