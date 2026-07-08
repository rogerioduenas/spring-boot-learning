package com.rogerio.onetoone_strategies.foreignKey;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "address")
  private User user;
}
