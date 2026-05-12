package com.rogerio.dto;

public class Post {

  private Long id;
  private String title;

  public Post(Long id, String title) {
    this.id = id;
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}
