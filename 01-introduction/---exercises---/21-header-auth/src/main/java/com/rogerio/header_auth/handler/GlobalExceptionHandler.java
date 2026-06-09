package com.rogerio.header_auth.handler;

import com.rogerio.header_auth.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<Void> handleUnauthorizedException() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
