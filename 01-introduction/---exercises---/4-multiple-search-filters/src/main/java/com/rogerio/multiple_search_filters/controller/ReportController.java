package com.rogerio.multiple_search_filters.controller;

import com.rogerio.multiple_search_filters.dto.ReportFilterDTO;
import com.rogerio.multiple_search_filters.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReportController {

  private final ReportService reportService;

  public ReportController(ReportService reportService) {
    this.reportService = reportService;
  }

  @GetMapping("/reports")
  public ResponseEntity<ReportFilterDTO> getReports(@RequestParam(required = false) Map<String, String> filters) {
    ReportFilterDTO reportFilterDTO = reportService.generateReport(filters);
    return ResponseEntity.ok(reportFilterDTO);
  }
}
