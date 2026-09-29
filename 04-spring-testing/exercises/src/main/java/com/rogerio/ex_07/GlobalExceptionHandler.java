package com.rogerio.ex_07;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component("ex07GlobalExceptionHandler")
public class GlobalExceptionHandler {

  @ExceptionHandler(InsufficientBalanceException.class)
  public ResponseEntity<BusinessErrorResponse> handleInsufficientBalance(InsufficientBalanceException ex) {
    BusinessErrorResponse error = new BusinessErrorResponse("BUSINESS_RULE_VIOLATION", ex.getMessage());
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
  }
}
