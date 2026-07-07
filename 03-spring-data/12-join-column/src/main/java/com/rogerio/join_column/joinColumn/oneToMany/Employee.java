package com.rogerio.join_column.joinColumn.oneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
  @SequenceGenerator(name = "gen_id", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
  private List<Email> emails = new ArrayList<>();

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public List<Email> getEmails() {
    return emails;
  }
}
