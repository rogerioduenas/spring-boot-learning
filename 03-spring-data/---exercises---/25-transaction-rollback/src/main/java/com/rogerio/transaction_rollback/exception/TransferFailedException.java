package com.rogerio.transaction_rollback.exception;

public class TransferFailedException extends Exception {
  public TransferFailedException(String message) {
    super(message);
  }
}
