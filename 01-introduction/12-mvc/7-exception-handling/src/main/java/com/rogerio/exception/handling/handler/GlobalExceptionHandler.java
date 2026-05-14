package com.rogerio.exception.handling.handler;

import com.rogerio.exception.handling.entity.CustomExceptionObject;
import com.rogerio.exception.handling.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CustomException1.class)
  public String handleException1(CustomException1 e) {
    return e.getMessage();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler
  public ProblemDetail handleException2(CustomException2 e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

    problemDetail.setTitle("Resource Not Found");
    problemDetail.setProperty("timestamp", Instant.now());
    problemDetail.setProperty("Help", "Check if your id is correct");

    return problemDetail;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(produces = MediaType.APPLICATION_JSON_VALUE)
  public CustomExceptionObject handleException3Json(CustomException3 e) {
    return new CustomExceptionObject();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(produces = MediaType.TEXT_PLAIN_VALUE)
  public String handleException3Text(CustomException3 e) {
    return "Simple text";
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
      CustomException4.class,
      CustomException5.class
  })
  public ResponseEntity<CustomExceptionObject> handleException45(Exception e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .header("My-Custom-Header", "ErrorProcessed")
        .body(new CustomExceptionObject());
  }
}
