package com.rogerio.proxy_association.model;

import jakarta.persistence.*;

@Entity
public class Review {

  @Id
  @GeneratedValue(generator = "gen_review", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_review", sequenceName = "seq_review", allocationSize = 1)
  private Long id;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Book book;

  public Review() {
  }

  public Review(String content, Book book) {
    this.content = content;
    this.book = book;
  }
}
