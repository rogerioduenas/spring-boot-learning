package com.rogerio.aop_auditor_performance.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
  public void fakeHeavyMethod() throws InterruptedException {
    Thread.sleep(1500);
  }
}
