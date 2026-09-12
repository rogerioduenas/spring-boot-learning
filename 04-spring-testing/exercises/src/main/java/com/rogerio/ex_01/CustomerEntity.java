package com.rogerio.ex_01;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_customers")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;
  private String email;

  @Enumerated(EnumType.STRING)
  private CustomerStatus status;

  public CustomerEntity() {}

  public CustomerEntity(String name, String email, CustomerStatus status) {
    this.name = name;
    this.email = email;
    this.status = status;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public CustomerStatus getStatus() { return status; }
}
