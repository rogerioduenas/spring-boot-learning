package com.rogerio.request_error_handling.handler;

import com.rogerio.request_error_handling.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<Object> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {

    String msg = "The 'id' parameter must be a valid number.";
    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(msg, HttpStatus.BAD_REQUEST);

    return handleExceptionInternal(ex, errorResponseDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
