package com.rogerio.manual_pagination.controller;

import com.rogerio.manual_pagination.dto.LogEntryResponseDTO;
import com.rogerio.manual_pagination.model.LogEntry;
import com.rogerio.manual_pagination.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {

  private final LogService logService;

  public LogController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping("/logs")
  public ResponseEntity<List<LogEntryResponseDTO>> listLogs(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {

    List<LogEntry> logEntries = logService.findByPageAndSize(page, size);
    List<LogEntryResponseDTO> dtos = logEntries.stream()
        .map(log -> new LogEntryResponseDTO(log.id(), log.message()))
        .toList();

    return ResponseEntity.ok(dtos);
  }
}
