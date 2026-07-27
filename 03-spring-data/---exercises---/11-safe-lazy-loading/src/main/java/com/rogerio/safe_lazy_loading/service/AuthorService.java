package com.rogerio.safe_lazy_loading.service;

import com.rogerio.safe_lazy_loading.dto.AuthorDTO;
import com.rogerio.safe_lazy_loading.model.Author;
import com.rogerio.safe_lazy_loading.model.Book;
import com.rogerio.safe_lazy_loading.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Transactional(readOnly = true)
  public AuthorDTO getAuthorDTO(Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new RuntimeException("Author not found"));

    List<String> bookTitles = author.getBooks()
        .stream()
        .map(Book::getName).toList();
    AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), bookTitles);

    return authorDTO;
  }
}
