package com.rogerio.order_creation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(generator = "gen_order", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_order", sequenceName = "seq_order", allocationSize = 1)
  private Long id;

  private String orderNumber;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> items = new ArrayList<>();

  public Order(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Order() {}

  public Long getId() {
    return id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void addItem(OrderItem item) {
    items.add(item);
    item.setOrder(this);
  }
}
