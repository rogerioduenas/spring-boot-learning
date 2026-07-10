package com.rogerio.onetoone_strategies.SharedPK;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToOne(mappedBy = "product")
  private ProductDetail details;

  public void setDetails(ProductDetail details) {
    this.details = details;
    if (details != null) {
      details.setProduct(this);
    }
  }

  public void setName(String name) {
    this.name = name;
  }
}
