package com.rogerio.library_checkout_flow.model;

import com.rogerio.library_checkout_flow.exception.InsufficientCopiesException;
import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(generator = "gen_book", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_book", sequenceName = "seq_book", allocationSize = 1)
  private Long id;

  private String title;
  private Integer availableCopies;

  public Book() {
  }
  public Book(String title, Integer availableCopies) {
    this.title = title;
    this.availableCopies = availableCopies;
  }

  public String getTitle() {
    return title;
  }

  public void decrementAvailableCopies() {
    if (this.availableCopies <= 0) {
      throw new InsufficientCopiesException("Book doesn't have available copies");
    }
    this.availableCopies--;
  }
}
