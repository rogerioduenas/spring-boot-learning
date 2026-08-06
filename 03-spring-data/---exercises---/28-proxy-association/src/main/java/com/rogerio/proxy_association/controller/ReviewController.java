package com.rogerio.proxy_association.controller;

import com.rogerio.proxy_association.dto.ReviewRequestDTO;
import com.rogerio.proxy_association.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  private final  ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody ReviewRequestDTO dto) {
    reviewService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
