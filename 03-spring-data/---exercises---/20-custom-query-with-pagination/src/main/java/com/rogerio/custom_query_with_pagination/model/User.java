package com.rogerio.custom_query_with_pagination.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;
  private Boolean active;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  public User() {
  }

  public User(String name, Boolean active, Department department) {
    this.name = name;
    this.active = active;
    this.department = department;
  }

  @Override
  public String toString() {
    return String.format("User[name=%s, active=%s, department=%s]", name, active, department.getName());
  }
}
