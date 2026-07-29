package com.rogerio.enum_converter.model;

import jakarta.persistence.*;

@Entity
public class Account {

  @Id
  @GeneratedValue(generator = "gen_account", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_account", sequenceName = "seq_account", allocationSize = 1)
  private Long id;

  private String ownerName;

  @Convert(converter = AccountStatusConverter.class)
  private AccountStatus status;

  public Account() {
  }

  public Account(String ownerName, AccountStatus status) {
    this.ownerName = ownerName;
    this.status = status;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", ownerName='" + ownerName + '\'' +
        ", status=" + status +
        '}';
  }
}
