package com.rogerio.read_only_reporting.config;

import com.rogerio.read_only_reporting.model.FinancialRecord;
import com.rogerio.read_only_reporting.repository.FinancialRecordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final FinancialRecordRepository financialRecordRepository;

  public DatabaseSeeder(FinancialRecordRepository financialRecordRepository) {
    this.financialRecordRepository = financialRecordRepository;
  }

  @Override
  public void run(String... args) throws Exception {
  if (financialRecordRepository.count() == 0) {
    List<FinancialRecord> financialRecords = new ArrayList<FinancialRecord>(List.of(
        new FinancialRecord("Aleatory description 01", BigDecimal.valueOf(2000)),
        new FinancialRecord("Aleatory description 02", BigDecimal.valueOf(3000)),
        new FinancialRecord("Aleatory description 03", BigDecimal.valueOf(4000))
    ));
    financialRecordRepository.saveAll(financialRecords);
  }
  }
}
