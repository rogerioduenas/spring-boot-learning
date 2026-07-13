package com.rogerio.cascade_types.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  @OneToMany(mappedBy = "person", cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE,
      CascadeType.REMOVE})
  private List<Address> addresses = new ArrayList<>();

  public List<Address> getAddresses() {
    return addresses;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
