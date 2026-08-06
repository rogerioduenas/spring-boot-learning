package com.rogerio.proxy_association.service;

import com.rogerio.proxy_association.dto.ReviewRequestDTO;
import com.rogerio.proxy_association.mapper.ReviewMapper;
import com.rogerio.proxy_association.model.Book;
import com.rogerio.proxy_association.model.Review;
import com.rogerio.proxy_association.repository.BookRepository;
import com.rogerio.proxy_association.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final BookRepository bookRepository;
  private final ReviewMapper reviewMapper;

  public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository, ReviewMapper reviewMapper) {
    this.reviewRepository = reviewRepository;
    this.bookRepository = bookRepository;
    this.reviewMapper = reviewMapper;
  }

  @Transactional
  public void save(ReviewRequestDTO dto) {
    Book book = bookRepository.getReferenceById(dto.bookId());
    Review review = reviewMapper.toEntity(dto, book);
    reviewRepository.save(review);
  }
}
