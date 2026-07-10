package com.rogerio.onetoone_strategies.SharedPK;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetail {

  @Id
  @Column(name = "product_id")
  private Long id;

  @Column(name = "weight")
  private Double weight;

  @OneToOne
  @MapsId
  @JoinColumn(name = "product_id")
  private Product product;

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }
}
