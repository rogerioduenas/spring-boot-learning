package com.rogerio.catalog_paging.model;

import jakarta.persistence.*;

@Entity
public class Category {

  @Id
  @GeneratedValue(generator = "gen_category", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_category", sequenceName = "seq_category", allocationSize = 1)
  private Long id;

  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
