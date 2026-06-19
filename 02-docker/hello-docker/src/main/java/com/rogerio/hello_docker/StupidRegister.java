package com.rogerio.hello_docker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StupidRegister {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String message;

  public StupidRegister() {}

  public StupidRegister(String message) {
    this.message = message;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }
}
