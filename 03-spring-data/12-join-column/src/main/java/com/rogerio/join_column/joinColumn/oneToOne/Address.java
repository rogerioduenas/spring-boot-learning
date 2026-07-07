package com.rogerio.join_column.joinColumn.oneToOne;

import jakarta.persistence.*;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
  @SequenceGenerator(name = "gen_id", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String city;

  public Address() {}

  public Address(String city) {
    this.city = city;
  }
}
