package com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToMany;

import jakarta.persistence.*;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  public Employee() {}

  public Employee(String name) {
    this.name = name;
  }
}
