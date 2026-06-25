package com.rogerio.unique_onstraints;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"personNumber", "isActive"})})
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;
  private Integer personNumber;
  private Boolean isActive;

  public Worker(String name, Integer personNumber, Boolean isActive) {
    this.name = name;
    this.personNumber = personNumber;
    this.isActive = isActive;
  }
}
