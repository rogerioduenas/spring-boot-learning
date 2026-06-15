package com.rogerio.ticket_management.handler;

import com.rogerio.ticket_management.dto.ErrorResponseDTO;
import com.rogerio.ticket_management.exception.TicketLimitExceededException;
import com.rogerio.ticket_management.exception.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<ErrorResponseDTO> handleTicketLimitExceededException(TicketLimitExceededException ex) {
    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(HttpStatus.BAD_REQUEST, ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResponseDTO> handleTicketNotFoundException(TicketNotFoundException ex) {
    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
  }
}
