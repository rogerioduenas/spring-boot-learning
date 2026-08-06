package com.rogerio.read_only_reporting.controller;

import com.rogerio.read_only_reporting.dto.FinancialRecordResponseDTO;
import com.rogerio.read_only_reporting.service.FinancialRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinancialRecordController {

  private final FinancialRecordService financialRecordService;

  public FinancialRecordController(FinancialRecordService financialRecordService) {
    this.financialRecordService = financialRecordService;
  }

  @GetMapping("/reports/financial")
  public ResponseEntity<List<FinancialRecordResponseDTO>> findAll() {
    List<FinancialRecordResponseDTO> dto = financialRecordService.findAll();
    return ResponseEntity.ok(dto);
  }
}
