package com.rogerio.transaction_rollback.handler;

import com.rogerio.transaction_rollback.dto.ErrorResponseDTO;
import com.rogerio.transaction_rollback.exception.TransferFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(TransferFailedException.class)
  public ResponseEntity<ErrorResponseDTO> handleTransferFailedException(TransferFailedException e) {
    String message = String.format("Transaction failed: %s All balances have been restored.", e.getMessage());
    return ResponseEntity.badRequest().body(new ErrorResponseDTO(message));
  }
}
