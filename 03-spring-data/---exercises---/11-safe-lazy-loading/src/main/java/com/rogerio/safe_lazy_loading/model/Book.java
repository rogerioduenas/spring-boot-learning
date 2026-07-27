package com.rogerio.safe_lazy_loading.model;

import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(generator = "gen_book", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_book", sequenceName = "seq_book", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  Author author;

  public Book() {
  }

  public Book(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
