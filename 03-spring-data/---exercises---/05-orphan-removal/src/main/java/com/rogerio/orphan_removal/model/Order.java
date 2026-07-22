package com.rogerio.orphan_removal.model;

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

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> items = new ArrayList<>();

  public Order() {
  }

  public Order(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long getId() {
    return id;
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    items.add(item);
    item.setOrder(this);
  }

  public void removeItem(Item item) {
    items.remove(item);
    item.setOrder(null);
  }
}
