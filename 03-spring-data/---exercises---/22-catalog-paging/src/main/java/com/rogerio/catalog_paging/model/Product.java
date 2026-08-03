package com.rogerio.catalog_paging.model;

import jakarta.persistence.*;

@Entity
public class Product {

  @Id
  @GeneratedValue(generator = "gen_product", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_product", sequenceName = "seq_product", allocationSize = 1)
  private Long id;
  private String name;
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  public Product() {
  }

  public Product(String name, Double price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Category getCategory() {
    return category;
  }
}
