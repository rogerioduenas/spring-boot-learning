package com.rogerio.product_registration.exception;

public class CategoryNotFound extends RuntimeException {
  public CategoryNotFound(String message) {
    super(message);
  }
}
