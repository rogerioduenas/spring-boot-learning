package com.rogerio.library_checkout_flow.exception;

public class InsufficientCopiesException extends RuntimeException {
  public InsufficientCopiesException(String message) {
    super(message);
  }
}
