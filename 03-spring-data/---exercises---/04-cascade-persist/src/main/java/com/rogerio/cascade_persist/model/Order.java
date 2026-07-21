package com.rogerio.cascade_persist.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(generator = "gen_order", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_order", sequenceName = "seq_order", allocationSize = 1)
  private Long id;

  private String orderNumber;

  @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
  private List<Item> items = new ArrayList<>();

  public Order() {
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void addItem(Item item) {
    this.items.add(item);
    item.setOrder(this);
  }
}
