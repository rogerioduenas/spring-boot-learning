package com.rogerio.batch_update.model;

import jakarta.persistence.*;

@Entity
public class Category {

  @Id
  @GeneratedValue(generator = "gen_category", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_category", sequenceName = "seq_category")
  private Long id;

  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
}
