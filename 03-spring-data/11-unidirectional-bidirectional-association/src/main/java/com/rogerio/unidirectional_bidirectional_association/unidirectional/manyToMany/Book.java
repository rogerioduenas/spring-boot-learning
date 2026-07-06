package com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String title;

  @ManyToMany
  @JoinTable(name = "book_author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors =  new HashSet<>();

  public Book(String title) {
    this.title = title;
  }

  public Set<Author> getAuthors() {
    return authors;
  }
}
