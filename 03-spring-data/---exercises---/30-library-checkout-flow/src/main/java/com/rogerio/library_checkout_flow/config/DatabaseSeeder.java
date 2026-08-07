package com.rogerio.library_checkout_flow.config;

import com.rogerio.library_checkout_flow.model.Book;
import com.rogerio.library_checkout_flow.model.Borrower;
import com.rogerio.library_checkout_flow.repository.BookRepository;
import com.rogerio.library_checkout_flow.repository.BorrowerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final BookRepository bookRepository;
  private final BorrowerRepository borrowerRepository;

  public DatabaseSeeder(BookRepository bookRepository, BorrowerRepository borrowerRepository) {
    this.bookRepository = bookRepository;
    this.borrowerRepository = borrowerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (bookRepository.count() == 0 && borrowerRepository.count() == 0) {
      bookRepository.save(new Book("Harry Potter", 5));
      borrowerRepository.save(new Borrower("John Smith"));
    }
  }
}
