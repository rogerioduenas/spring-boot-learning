package com.rogerio.inventory_validation.handler;

import com.rogerio.inventory_validation.exception.InsufficientStockException;
import com.rogerio.inventory_validation.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ProductExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<ProblemDetail> handleProductNotFoundException(ProductNotFoundException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    problemDetail.setTitle("Product Not Found.");
    problemDetail.setProperty("timestamp", Instant.now());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
  }

  @ExceptionHandler
  public ResponseEntity<ProblemDetail> handleInsufficientStockException(InsufficientStockException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    problemDetail.setTitle("Insufficient stock!");
    problemDetail.setProperty("timestamp", Instant.now());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
  }
}
