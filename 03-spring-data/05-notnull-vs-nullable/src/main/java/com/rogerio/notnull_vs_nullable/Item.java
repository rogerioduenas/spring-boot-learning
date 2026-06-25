package com.rogerio.notnull_vs_nullable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

//    @NotNull
  @Column(nullable = false)
  private Double price;
}
