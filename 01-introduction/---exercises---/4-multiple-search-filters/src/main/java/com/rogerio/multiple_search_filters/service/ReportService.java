package com.rogerio.multiple_search_filters.service;

import com.rogerio.multiple_search_filters.dto.ReportFilterDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportService {

  public ReportFilterDTO generateReport(Map<String, String> filter) {
    System.out.println("Generating report for filter: " + filter);
    return new ReportFilterDTO(filter);
  }
}
