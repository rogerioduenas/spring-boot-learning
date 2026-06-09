package com.rogerio.manual_pagination.repository;

import com.rogerio.manual_pagination.model.LogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogRepository {

  private final List<LogEntry> logEntries = new ArrayList<>(List.of(
      new LogEntry(1L, "Aleatory message: log 1"),
      new LogEntry(2L, "Aleatory message: log 2"),
      new LogEntry(3L, "Aleatory message: log 3"),
      new LogEntry(4L, "Aleatory message: log 4"),
      new LogEntry(5L, "Aleatory message: log 5"),
      new LogEntry(6L, "Aleatory message: log 6"),
      new LogEntry(7L, "Aleatory message: log 7"),
      new LogEntry(8L, "Aleatory message: log 8"),
      new LogEntry(9L, "Aleatory message: log 9"),
      new LogEntry(10L, "Aleatory message: log 10"),
      new LogEntry(11L, "Aleatory message: log 11"),
      new LogEntry(12L, "Aleatory message: log 12")
  ));

  public List<LogEntry> findAll() {
    return logEntries;
  }
}
