package com.rogerio.soft_delete.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE customer SET active = false WHERE id = ?")
@SQLRestriction("active = true")
public class Customer {

  @Id
  @GeneratedValue(generator = "gen_customer", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_customer", sequenceName = "seq_customer", allocationSize = 1)
  private Long id;

  private String name;
  private Boolean active = true;

  public Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
