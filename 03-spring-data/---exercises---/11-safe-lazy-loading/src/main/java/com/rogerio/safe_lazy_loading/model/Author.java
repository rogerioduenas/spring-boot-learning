package com.rogerio.safe_lazy_loading.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

  @Id
  @GeneratedValue(generator = "gen_author", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_author", sequenceName = "seq_author", allocationSize = 1)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
  List<Book> books = new ArrayList<>();

  public Author() {
  }

  public Author(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void addBook(Book book) {
    books.add(book);
    book.setAuthor(this);
  }
}
