package com.rogerio.proxy_association.model;

import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(generator = "gen_book", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_book", sequenceName = "seq_book", allocationSize = 1)
  private Long id;

  private String title;

  public Book() {}

  public Book(String title) {
    this.title = title;
  }
}
