package com.rogerio.n_plus_one_resolver.model;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(generator = "gen_employee", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_employee", sequenceName = "seq_employee", allocationSize = 1)
  private Long id;
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  private Company company;


  public Employee() {}

  public Employee(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
