package com.rogerio.catalog_paging.exception;

public class CategoryNotFound extends RuntimeException {
  public CategoryNotFound(String message) {
    super(message);
  }
}
