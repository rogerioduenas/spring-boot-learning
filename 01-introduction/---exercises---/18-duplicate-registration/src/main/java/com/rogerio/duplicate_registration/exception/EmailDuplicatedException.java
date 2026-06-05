package com.rogerio.duplicate_registration.exception;

public class EmailDuplicatedException extends RuntimeException {
  public EmailDuplicatedException(String message) {
    super(message);
  }
}
