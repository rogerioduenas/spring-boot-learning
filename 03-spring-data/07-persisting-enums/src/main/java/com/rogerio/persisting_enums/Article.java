package com.rogerio.persisting_enums;

import jakarta.persistence.*;

@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
  @SequenceGenerator(name = "article_seq", sequenceName = "article_sequence", allocationSize = 1)
  private Long id;

  private String title;

  @Enumerated(EnumType.STRING)
  private Type type;

  private Category category;

  public Article() {}

  public Article(String title, Type type, Category category) {
    this.title = title;
    this.type = type;
    this.category = category;
  }
}
