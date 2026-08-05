package com.rogerio.n_plus_one_resolver.handler;

import com.rogerio.n_plus_one_resolver.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    problemDetail.setTitle("Resource Not Found");
    problemDetail.setType(URI.create(request.getRequestURI()));
    return problemDetail;
  }
}
