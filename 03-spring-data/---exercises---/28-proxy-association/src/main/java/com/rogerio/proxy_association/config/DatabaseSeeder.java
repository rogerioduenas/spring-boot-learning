package com.rogerio.proxy_association.config;

import com.rogerio.proxy_association.model.Book;
import com.rogerio.proxy_association.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final BookRepository bookRepository;

  public DatabaseSeeder(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (bookRepository.count() == 0) {
      bookRepository.save(new Book("Harry Potter"));
    }
  }
}
