package com.rogerio.duplicate_registration.handler;

import com.rogerio.duplicate_registration.dto.ErrorResponseDTO;
import com.rogerio.duplicate_registration.exception.EmailDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailDuplicatedException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmailDuplicated(EmailDuplicatedException ex) {
      ErrorResponseDTO error = new ErrorResponseDTO(ex.getMessage(), HttpStatus.CONFLICT);
      return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
  }