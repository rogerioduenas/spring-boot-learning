package com.rogerio.department_assignment.exception;

public class DepartmentNotFoundException extends RuntimeException {
  public DepartmentNotFoundException(String message) {
    super(message);
  }
}
