package com.rogerio.ticket_management.exception;

public class TicketLimitExceededException extends RuntimeException {
  public TicketLimitExceededException(String message) {
    super(message);
  }
}
