package com.rogerio.cascade_persist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class Item {

  @Id
  @GeneratedValue(generator = "gen_item", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_item", sequenceName = "seq_item", allocationSize = 1)
  private Long id;

  private String name;
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  public Item() {
  }

  public Item(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
