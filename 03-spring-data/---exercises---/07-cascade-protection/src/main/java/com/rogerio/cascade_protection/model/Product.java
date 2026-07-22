package com.rogerio.cascade_protection.model;

import jakarta.persistence.*;

@Entity
public class Product {

  @Id
  @GeneratedValue(generator = "gen_prod", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_prod", sequenceName = "seq_prod", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "category_id")
  private Category category;

  public Product() {
  }

  public Product(String name, Category category) {
    this.name = name;
    this.category = category;
  }

  public Long getId() {
    return id;
  }
}
