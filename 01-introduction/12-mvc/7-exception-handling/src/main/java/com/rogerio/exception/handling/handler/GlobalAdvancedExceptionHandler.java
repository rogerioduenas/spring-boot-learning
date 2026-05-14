package com.rogerio.exception.handling.handler;

import org.springframework.http.*;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalAdvancedExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    // The user sent an XML file, but you only accept JSON.
    String detail = "Media format not supported. Please use JSON.";
    ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
    problem.setTitle("Invalid Media");

    return ResponseEntity.status(status).body(problem);
  }
}
