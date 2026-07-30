package com.rogerio.transaction_rollback.model;

import jakarta.persistence.*;

@Entity
public class Invoice {

  @Id
  @GeneratedValue(generator = "gen_invoice", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_invoice", sequenceName = "seq_invoice", allocationSize = 1)
  private Long id;

  private Double amount;

  public Invoice() {
  }

  public Invoice(Double amount) {
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
