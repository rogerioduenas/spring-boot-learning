package com.rogerio.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-rest")
public class BookRestController {

  @GetMapping(value = "/{id}", produces = "application/json")
  public Book getBook(@PathVariable Long id) {
    return findBookById(id);
  }

  private Book findBookById(Long id) {
    return new Book(id, "My Happy Book");
  }
}
