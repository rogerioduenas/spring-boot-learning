package com.rogerio.service_billing.model;

public class Item {
  private final Long id;
  private final String description;
  private Double price;

  public Item(Long id, String description, Double price) {
    this.id = id;
    this.description = description;
    this.price = price;
  }

  public Long getId() { return id; }
  public String getDescription() { return description; }
  public Double getPrice() { return price; }

  public void setPrice(Double price) {
    this.price = price;
  }
}