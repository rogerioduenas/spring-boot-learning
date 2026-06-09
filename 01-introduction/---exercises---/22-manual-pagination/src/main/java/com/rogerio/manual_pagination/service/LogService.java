package com.rogerio.manual_pagination.service;

import com.rogerio.manual_pagination.model.LogEntry;
import com.rogerio.manual_pagination.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

  private final LogRepository logRepository;

  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public List<LogEntry> findByPageAndSize(int page, int size) {
    List<LogEntry> logEntries = logRepository.findAll();

    int start = page * size;
    int end = Math.min((start + size), logEntries.size());

    if(start >= logEntries.size() || start < 0) {
      return List.of();
    }

    return logEntries.subList(start, end);
  }
}
