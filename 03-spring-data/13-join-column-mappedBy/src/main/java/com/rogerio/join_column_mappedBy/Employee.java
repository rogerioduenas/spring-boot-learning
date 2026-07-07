package com.rogerio.join_column_mappedBy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
  private List<Email> emails = new ArrayList<>();

  private String name;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public List<Email> getEmails() {
    return emails;
  }
}
