package com.rogerio.transaction_rollback.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Wallet {

  @Id
  @GeneratedValue(generator = "gen_wallet", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_wallet", sequenceName = "seq_wallet", allocationSize = 1)
  private Long id;
  private String holderName;
  private BigDecimal balance;

  public Wallet() {
  }

  public Wallet(String holderName, BigDecimal balance) {
    this.holderName = holderName;
    this.balance = balance;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
