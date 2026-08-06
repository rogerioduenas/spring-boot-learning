package com.rogerio.unique_constraint_handling.model;

import jakarta.persistence.*;

@Entity
public class Account {

  @Id
  @GeneratedValue(generator = "gen_account", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_account", sequenceName = "seq_account", allocationSize = 1)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String taxId;

  public Account() {
  }

  public Account(String email, String taxId) {
    this.email = email;
    this.taxId = taxId;
  }
}
