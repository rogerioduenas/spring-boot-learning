package com.rogerio.http_response_customizer.service;

import com.rogerio.http_response_customizer.dto.BatchReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchProcessService {

  public BatchReport processBatch(List<String> listItems) {
    int success = 0;
    int failure = 0;

    for (String item : listItems) {
      if (item != null && item.contains("ERROR")) {
        failure++;
      } else {
        success++;
      }
    }

    return new BatchReport(success, failure);
  }
}
