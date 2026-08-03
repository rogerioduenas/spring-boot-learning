package com.rogerio.catalog_paging.handler;

import com.rogerio.catalog_paging.exception.CategoryNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CategoryNotFound.class)
  public ProblemDetail handleCategoryNotFound(CategoryNotFound ex, HttpServletRequest request) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatus.NOT_FOUND,
        ex.getMessage()
    );
    problemDetail.setTitle("Category Not Found");
    problemDetail.setType(URI.create(request.getRequestURI()));
    problemDetail.setProperty("Timestamp", Instant.now());

    return problemDetail;
  }
}
