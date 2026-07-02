package com.rogerio.sequence_allocation_order;

import jakarta.persistence.*;

@Entity
public class MyHappyUser {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
  @SequenceGenerator(name = "gen_id", sequenceName = "user_seq", allocationSize = 1)
  private Long id;

  private String name;
  private Integer age;

  public Long getId() {
    return id;
  }
}
