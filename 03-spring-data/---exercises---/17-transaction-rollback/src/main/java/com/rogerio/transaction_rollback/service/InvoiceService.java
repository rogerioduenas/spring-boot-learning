package com.rogerio.transaction_rollback.service;

import com.rogerio.transaction_rollback.exception.InvoiceProcessingException;
import com.rogerio.transaction_rollback.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

  private final InvoiceRepository invoiceRepository;

  public InvoiceService(InvoiceRepository invoiceRepository) {
    this.invoiceRepository = invoiceRepository;
  }

  @Transactional(rollbackFor = Exception.class)
  public void processInvoice(Long id, Double amount) throws InvoiceProcessingException {
    invoiceRepository.findById(id)
        .ifPresent(invoice -> invoice.setAmount(amount));

    // --- intentionally throw an exception to demonstrate the rollback occurring ---
    throw new InvoiceProcessingException(String.format("Invoice with id %s was not processed", id));
  }
}
