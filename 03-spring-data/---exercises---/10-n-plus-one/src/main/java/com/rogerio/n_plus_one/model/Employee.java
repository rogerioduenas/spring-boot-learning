package com.rogerio.n_plus_one.model;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(generator = "gen_empl", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_empl", sequenceName = "seq_empl", allocationSize = 1)
  private Long id;
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  Company company;

  public Employee() {
  }

  public Employee(String name, Company company) {
    this.name = name;
    this.company = company;
  }
}
