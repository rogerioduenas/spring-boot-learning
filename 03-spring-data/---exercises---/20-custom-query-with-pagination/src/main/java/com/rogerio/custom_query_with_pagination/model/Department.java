package com.rogerio.custom_query_with_pagination.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;

  public Department() {
  }

  public Department(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
