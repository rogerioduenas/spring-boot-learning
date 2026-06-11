package com.rogerio.payment_critical_logger.exception;

import com.rogerio.payment_critical_logger.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<ErrorResponseDTO> handleConflict(RuntimeException ex) {
    return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage()), HttpStatus.CONFLICT);
  }
}
