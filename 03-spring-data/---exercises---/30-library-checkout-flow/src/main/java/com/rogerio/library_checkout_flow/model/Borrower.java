package com.rogerio.library_checkout_flow.model;

import jakarta.persistence.*;

@Entity
public class Borrower {

  @Id
  @GeneratedValue(generator = "gen_borrower", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_borrower", sequenceName = "seq_borrower", allocationSize = 1)
  private Long id;

  private String name;

  public Borrower() {}

  public Borrower(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
