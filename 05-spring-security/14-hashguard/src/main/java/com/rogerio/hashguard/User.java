package com.rogerio.hashguard;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  public User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getPassword() { return password; }
}
