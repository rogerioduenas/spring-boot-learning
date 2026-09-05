package com.rogerio.end_to_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private BigDecimal price;

  public Product() {}

  public Product(Long id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public BigDecimal getPrice() { return price; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) && Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
