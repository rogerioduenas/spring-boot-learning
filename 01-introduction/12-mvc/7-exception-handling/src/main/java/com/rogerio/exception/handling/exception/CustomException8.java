package com.rogerio.exception.handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//lazy mode for fast things, it doesn't have personalization.
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource doesn't found")
public class CustomException8 extends RuntimeException {
  public CustomException8(String message) {
    super(message);
  }
}
