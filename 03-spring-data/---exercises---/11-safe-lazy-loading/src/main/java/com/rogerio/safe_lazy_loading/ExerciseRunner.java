package com.rogerio.safe_lazy_loading;

import com.rogerio.safe_lazy_loading.dto.AuthorDTO;
import com.rogerio.safe_lazy_loading.model.Author;
import com.rogerio.safe_lazy_loading.model.Book;
import com.rogerio.safe_lazy_loading.repository.AuthorRepository;
import com.rogerio.safe_lazy_loading.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final AuthorService authorService;

  public ExerciseRunner(AuthorRepository authorRepository, AuthorService authorService) {
    this.authorRepository = authorRepository;
    this.authorService = authorService;
  }

  @Override
  public void run(String... args) throws Exception {

    Author author = new Author("Anna");
    author.addBook(new Book("book 1"));
    author.addBook(new Book("book 2"));
    author.addBook(new Book("book 3"));
    authorRepository.save(author);

    AuthorDTO authorDTO = authorService.getAuthorDTO(author.getId());
    System.out.println(authorDTO);
  }
}
