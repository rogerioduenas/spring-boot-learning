package com.rogerio.batch_update.model;

import jakarta.persistence.*;

@Entity
public class Product {

  @Id
  @GeneratedValue(generator = "gen_product", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_product", sequenceName = "seq_product")
  private Long id;

  private String name;
  private Double price;


  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "category_id")
  private Category category;

  public Product() {
  }

  public Product(String name, Double price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public Double getPrice() {
    return price;
  }
}
