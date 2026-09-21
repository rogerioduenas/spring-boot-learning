package com.rogerio.exception_handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AuthenticationException.class)
  public ProblemDetail handleAuthenticationException(AuthenticationException ex, HttpServletRequest request) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());
    problemDetail.setTitle("Authentication Failed");
    problemDetail.setType(URI.create(request.getRequestURI()));

    return problemDetail;
  }
}
