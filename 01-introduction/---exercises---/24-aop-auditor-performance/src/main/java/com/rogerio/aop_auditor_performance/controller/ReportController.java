package com.rogerio.aop_auditor_performance.controller;

import com.rogerio.aop_auditor_performance.dto.ReportResponseDTO;
import com.rogerio.aop_auditor_performance.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private final ReportService reportService;

  public ReportController(ReportService reportService) {
    this.reportService = reportService;
  }

  @GetMapping("/heavy")
  public ResponseEntity<ReportResponseDTO> heavyMethod() throws InterruptedException {
    reportService.fakeHeavyMethod();
    return ResponseEntity.status(HttpStatus.OK).body(new ReportResponseDTO("fakeHeavyMethod executed!"));
  }
}
