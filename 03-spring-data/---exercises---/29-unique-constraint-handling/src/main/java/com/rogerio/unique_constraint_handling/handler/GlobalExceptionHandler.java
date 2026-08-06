package com.rogerio.unique_constraint_handling.handler;

import com.rogerio.unique_constraint_handling.dto.ErrorResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ErrorResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDTO(
        "Account registration conflict. The email or Tax ID already exists."
    ));
  }
}
