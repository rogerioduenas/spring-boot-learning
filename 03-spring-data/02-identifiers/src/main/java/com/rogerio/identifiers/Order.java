package com.rogerio.identifiers;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
  @SequenceGenerator(name = "order_seq", sequenceName = "seq_order", allocationSize = 1)
  private Long id;

  private String description;

  public Order() {}
}
