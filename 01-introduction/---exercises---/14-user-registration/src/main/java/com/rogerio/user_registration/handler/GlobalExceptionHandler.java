package com.rogerio.user_registration.handler;

import com.rogerio.user_registration.dto.ErrorResponseDTO;
import com.rogerio.user_registration.exception.InvalidAgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<ErrorResponseDTO> handleInvalidAgeException(InvalidAgeException e) {
    ErrorResponseDTO error = new ErrorResponseDTO(e.getMessage());
    return ResponseEntity
        .status(HttpStatus.UNPROCESSABLE_CONTENT)
        .body(error);
  }
}
