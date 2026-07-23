package com.rogerio.shared_primary_key.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(generator = "gen_user", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_user", sequenceName = "seq_user", allocationSize = 1)
  private Long id;

  private String name;

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
}
