package com.rogerio.ticket_management.model;

public class Ticket {
  private Long id;
  private final String title;
  private final String description;
  private final Priority priority;
  private Boolean isClosed;

  public Ticket(String title, String description, Priority priority) {
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.isClosed = false;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Priority getPriority() {
    return priority;
  }

  public Boolean getIsClosed() {
    return isClosed;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setIsClosed(Boolean closed) {
    isClosed = closed;
  }
}
