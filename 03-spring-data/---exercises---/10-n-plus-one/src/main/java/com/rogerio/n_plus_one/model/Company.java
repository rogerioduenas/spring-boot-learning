package com.rogerio.n_plus_one.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

  @Id
  @GeneratedValue(generator = "gen_company", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_company", sequenceName = "seq_company", allocationSize = 1)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "company")
  List<Employee> employees = new ArrayList<>();

  public Company() {
  }

  public Company(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }
}
