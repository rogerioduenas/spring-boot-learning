package com.rogerio.join_column.joinColumn.oneToOne;

import jakarta.persistence.*;

@Entity
public class Office {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
  @SequenceGenerator(name = "gen_id", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  private Address address;

  public void setAddress(Address address) {
    this.address = address;
  }
}
