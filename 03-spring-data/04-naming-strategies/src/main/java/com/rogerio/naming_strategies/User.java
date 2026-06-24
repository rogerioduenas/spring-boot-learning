package com.rogerio.naming_strategies;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long userId;
  private String firstName;
  private String lastName;
}
