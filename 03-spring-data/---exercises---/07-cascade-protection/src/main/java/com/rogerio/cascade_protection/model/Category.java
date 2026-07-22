package com.rogerio.cascade_protection.model;

import jakarta.persistence.*;

@Entity
public class Category {

  @Id
  @GeneratedValue(generator = "gen_cat", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_cat", sequenceName = "seq_cat", allocationSize = 1)
  private Long id;

  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }
}
