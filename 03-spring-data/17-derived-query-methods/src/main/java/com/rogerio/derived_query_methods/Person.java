package com.rogerio.derived_query_methods;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  public Person() {}

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("id: %d, name:'%s'%n", id, name);
  }
}
