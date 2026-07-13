package com.rogerio.cascade_types.entities;

import jakarta.persistence.*;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int houseNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  private Person person;

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
