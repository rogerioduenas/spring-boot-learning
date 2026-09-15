package com.rogerio.ex_03;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_accounts")
public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String owner;
  private Double balance;

  public AccountEntity() {}

  public AccountEntity(String owner, Double balance) {
    this.owner = owner;
    this.balance = balance;
  }

  public Long getId() { return id; }
  public String getOwner() { return owner; }
  public Double getBalance() { return balance; }
  public void setBalance(Double balance) { this.balance = balance; }
}
