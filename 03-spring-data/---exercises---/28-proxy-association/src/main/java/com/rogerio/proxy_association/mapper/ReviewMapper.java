package com.rogerio.proxy_association.mapper;

import com.rogerio.proxy_association.dto.ReviewRequestDTO;
import com.rogerio.proxy_association.model.Book;
import com.rogerio.proxy_association.model.Review;
import com.rogerio.proxy_association.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

  public Review toEntity(ReviewRequestDTO dto, Book book) {
    return new Review(
        dto.content(),
        book
        );
  }
}
