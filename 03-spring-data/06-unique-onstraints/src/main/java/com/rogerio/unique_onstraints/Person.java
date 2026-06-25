package com.rogerio.unique_onstraints;

import jakarta.persistence.*;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  @Column(unique = true)
  private String email;

  private Integer personNumber;
  private Boolean isActive;

  public Person(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
