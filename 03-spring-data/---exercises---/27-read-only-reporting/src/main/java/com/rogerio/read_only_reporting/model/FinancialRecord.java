package com.rogerio.read_only_reporting.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FinancialRecord {

  @Id
  @GeneratedValue(generator = "gen_fin_rec", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_fin_rec", sequenceName = "seq_fin_rec", allocationSize = 1)
  private Long id;

  private String description;
  private BigDecimal amount;

  public FinancialRecord() {}

  public FinancialRecord(String description, BigDecimal amount) {
    this.description = description;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
