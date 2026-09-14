package com.rogerio.ex_02;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, nullable = false)
  private String cpf;

  public UserEntity() {}

  public UserEntity(String name, String email, String cpf) {
    this.name = name;
    this.email = email;
    this.cpf = cpf;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getCpf() { return cpf; }
}
