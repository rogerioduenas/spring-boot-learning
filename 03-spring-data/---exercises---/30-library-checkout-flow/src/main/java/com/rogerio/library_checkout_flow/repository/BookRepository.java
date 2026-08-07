package com.rogerio.library_checkout_flow.repository;

import com.rogerio.library_checkout_flow.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
