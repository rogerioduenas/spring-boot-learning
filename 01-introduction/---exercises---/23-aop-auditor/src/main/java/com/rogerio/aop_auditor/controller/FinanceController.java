package com.rogerio.aop_auditor.controller;

import com.rogerio.aop_auditor.dto.RevenueResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {

  @GetMapping("/revenue")
  public ResponseEntity<RevenueResponseDTO> getRevenue() {
    return ResponseEntity.status(HttpStatus.OK).body(new RevenueResponseDTO("Revenue is done!"));
  }
}
