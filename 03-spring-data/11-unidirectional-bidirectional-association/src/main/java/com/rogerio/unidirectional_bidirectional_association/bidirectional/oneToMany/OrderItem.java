package com.rogerio.unidirectional_bidirectional_association.bidirectional.oneToMany;

import jakarta.persistence.*;

@Entity
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  public OrderItem(String name) {
    this.name = name;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}