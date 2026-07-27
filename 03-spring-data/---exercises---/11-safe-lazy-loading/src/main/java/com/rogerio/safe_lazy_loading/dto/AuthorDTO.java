package com.rogerio.safe_lazy_loading.dto;

import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {

  private Long id;
  private String name;
  private List<String> bookTitles = new ArrayList<>();

  public AuthorDTO(Long id, String name, List<String> bookTitles) {
    this.id = id;
    this.name = name;
    this.bookTitles = bookTitles;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<String> getBookTitles() {
    return bookTitles;
  }

  @Override
  public String toString() {
    return String.format("%s - %s", name, bookTitles);
  }
}