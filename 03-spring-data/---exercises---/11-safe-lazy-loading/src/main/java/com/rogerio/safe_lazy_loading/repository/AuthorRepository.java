package com.rogerio.safe_lazy_loading.repository;

import com.rogerio.safe_lazy_loading.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
