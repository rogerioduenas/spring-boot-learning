package com.rogerio.http_response_customizer.controller;

import com.rogerio.http_response_customizer.dto.BatchProcessRequestDTO;
import com.rogerio.http_response_customizer.dto.BatchProcessResponseDTO;
import com.rogerio.http_response_customizer.dto.BatchReport;
import com.rogerio.http_response_customizer.service.BatchProcessService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BatchProcessController {

  private final BatchProcessService batchProcessService;

  public BatchProcessController(BatchProcessService batchProcessService) {
    this.batchProcessService = batchProcessService;
  }

  @PostMapping("/batch-process")
  public ResponseEntity<BatchProcessResponseDTO> batchProcess(@RequestBody BatchProcessRequestDTO requestDTO) {
    BatchReport batchReport = batchProcessService.processBatch(requestDTO.listItems());

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Success-Count", String.valueOf(batchReport.successCount()));
    headers.add("X-Failed-Count", String.valueOf(batchReport.failedCount()));

    Map<String, Integer> summary = Map.of(
        "successCount", batchReport.successCount(),
        "failedCount", batchReport.failedCount());

    return ResponseEntity.ok()
        .headers(headers)
        .body(new BatchProcessResponseDTO("Batch processed successfully.", summary));
  }
}
