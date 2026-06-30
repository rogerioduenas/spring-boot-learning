package com.rogerio.entity_lifecycle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String title;
  private String type;

  public Article() {
  }

  public Article(String title, String type) {
    this.title = title;
    this.type = type;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}