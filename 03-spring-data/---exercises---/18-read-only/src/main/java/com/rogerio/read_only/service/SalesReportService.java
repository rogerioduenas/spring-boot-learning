package com.rogerio.read_only.service;

import com.rogerio.read_only.model.SaleTransaction;
import com.rogerio.read_only.repository.SaleTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesReportService {

  private final SaleTransactionRepository saleTransactionRepository;

  public SalesReportService(SaleTransactionRepository saleTransactionRepository) {
    this.saleTransactionRepository = saleTransactionRepository;
  }

  @Transactional(readOnly = true)
  public List<SaleTransaction> getDailyReport(){
    List<SaleTransaction> transactions = saleTransactionRepository.findAll();

    // Updates the object in local memory,
    // but read-only mode disables dirty checking,
    // so no UPDATE is sent to the database.
    transactions.stream()
        .filter(st -> st.getId().equals(1L))
        .findFirst()
        .ifPresent(st -> st.setAmount(99999.0));

    return transactions;
  }
}
