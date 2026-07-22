package com.rogerio.orphan_removal.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "items")
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

  public Long getId() {
    return id;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(getId(), item.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
