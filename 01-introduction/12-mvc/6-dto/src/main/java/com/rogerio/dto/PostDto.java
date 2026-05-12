package com.rogerio.dto;

public class PostDto {

  private Long id;
  private String title;

  public PostDto(Long id, String title) {
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
