package com.rogerio.read_only.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SaleTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private Double amount;
  private LocalDateTime date;

  public SaleTransaction() {
  }

  public SaleTransaction(Double amount, LocalDateTime date) {
    this.amount = amount;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "SaleTransaction{" +
        "id=" + id +
        ", amount=" + amount +
        ", date=" + date +
        '}';
  }
}
