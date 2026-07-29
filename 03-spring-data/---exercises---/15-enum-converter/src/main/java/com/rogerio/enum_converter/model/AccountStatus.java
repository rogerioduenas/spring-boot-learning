package com.rogerio.enum_converter.model;

public enum AccountStatus {
  ACTIVE("A"),
  INACTIVE("I"),
  SUSPENDED("S");

  private final String value;

  AccountStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
