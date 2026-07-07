package com.rogerio.join_column.joinColumns;

import jakarta.persistence.*;

@Entity
@IdClass(ProductId.class)
public class Product {

  @Id
  private Long id;

  @Id
  private Integer barCode;

  public void setId(Long id) {
    this.id = id;
  }

  public void setBarCode(Integer barCode) {
    this.barCode = barCode;
  }
}
