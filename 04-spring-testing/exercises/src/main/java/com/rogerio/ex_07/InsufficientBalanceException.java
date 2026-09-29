package com.rogerio.ex_07;

public class InsufficientBalanceException extends RuntimeException {
  public InsufficientBalanceException(String message) {
    super(message);
  }
}
