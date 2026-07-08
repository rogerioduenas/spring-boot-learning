package com.rogerio.onetoone_strategies.foreignKey;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  public void setAddress(Address address) {
    this.address = address;
  }
}
