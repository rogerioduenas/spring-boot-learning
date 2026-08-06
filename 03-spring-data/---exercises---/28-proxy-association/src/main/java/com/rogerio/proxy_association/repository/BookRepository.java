package com.rogerio.proxy_association.repository;

import com.rogerio.proxy_association.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
