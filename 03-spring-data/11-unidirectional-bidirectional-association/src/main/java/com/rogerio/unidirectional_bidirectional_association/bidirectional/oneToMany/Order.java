package com.rogerio.unidirectional_bidirectional_association.bidirectional.oneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> items = new ArrayList<>();

  public List<OrderItem> getItems() {
    return items;
  }
}
