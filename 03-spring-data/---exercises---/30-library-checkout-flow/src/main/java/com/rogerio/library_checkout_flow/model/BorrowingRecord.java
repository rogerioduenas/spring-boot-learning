package com.rogerio.library_checkout_flow.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BorrowingRecord {

  @Id
  @GeneratedValue(generator = "gen_borrowingRecord", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_borrowingRecord", sequenceName = "seq_borrowingRecord", allocationSize = 1)
  private Long id;


  @ManyToOne(fetch = FetchType.LAZY)
  private Book book;

  @ManyToOne(fetch = FetchType.LAZY)
  private Borrower borrower;

  private LocalDate borrowDate;

  public BorrowingRecord() {
  }

  public BorrowingRecord(Book book, Borrower borrower, LocalDate borrowDate) {
    this.book = book;
    this.borrower = borrower;
    this.borrowDate = borrowDate;
  }

  public Long getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public Borrower getBorrower() {
    return borrower;
  }

  public LocalDate getBorrowDate() {
    return borrowDate;
  }
}
