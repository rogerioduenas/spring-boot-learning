package com.rogerio.read_only;

import com.rogerio.read_only.model.SaleTransaction;
import com.rogerio.read_only.repository.SaleTransactionRepository;
import com.rogerio.read_only.service.SalesReportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final SalesReportService salesReportService;
  private final SaleTransactionRepository saleTransactionRepository;

  public ExerciseRunner(SalesReportService salesReportService, SaleTransactionRepository saleTransactionRepository) {
    this.salesReportService = salesReportService;
    this.saleTransactionRepository = saleTransactionRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    saleTransactionRepository
        .save(new SaleTransaction(100.0, LocalDateTime.now()));

    salesReportService.getDailyReport()
        .forEach(System.out::println);
  }
}
