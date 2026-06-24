package com.rogerio.entity_lifecycle;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
