package com.rogerio.join_column.joinColumns;

import jakarta.persistence.*;

@Entity
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns({
      @JoinColumn(name = "product_id", referencedColumnName = "id"),
      @JoinColumn(name = "product_bar_code", referencedColumnName = "barCode")
  })
  private Product product;

  public void setProduct(Product product) {
    this.product = product;
  }
}
