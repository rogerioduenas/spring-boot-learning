package com.rogerio.order_creation.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

  @Id
  @GeneratedValue(generator = "gen_orderItem", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_orderItem", sequenceName = "seq_orderItem", allocationSize = 1)
  private Long id;

  private String productName;
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  public OrderItem(String productName, Double price) {
    this.productName = productName;
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
