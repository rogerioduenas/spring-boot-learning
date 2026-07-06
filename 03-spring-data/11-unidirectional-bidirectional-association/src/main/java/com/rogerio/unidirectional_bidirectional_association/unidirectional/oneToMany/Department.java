package com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @OneToMany
  @JoinColumn(name = "department_id")
  private List<Employee> employees = new ArrayList<>();

  public Department(String name) {
    this.name = name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }
}
