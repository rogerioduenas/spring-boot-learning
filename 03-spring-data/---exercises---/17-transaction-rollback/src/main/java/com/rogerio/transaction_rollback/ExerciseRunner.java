package com.rogerio.transaction_rollback;

import com.rogerio.transaction_rollback.exception.InvoiceProcessingException;
import com.rogerio.transaction_rollback.model.Invoice;
import com.rogerio.transaction_rollback.repository.InvoiceRepository;
import com.rogerio.transaction_rollback.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final InvoiceService invoiceService;
  private final InvoiceRepository invoiceRepository;

  public ExerciseRunner(InvoiceService invoiceService, InvoiceRepository invoiceRepository) {
    this.invoiceService = invoiceService;
    this.invoiceRepository = invoiceRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Invoice invoice = invoiceRepository.save(new Invoice(200.0));

    try {
      invoiceService.processInvoice(invoice.getId(), 100.0);
    } catch (InvoiceProcessingException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }

    // Check the value in the database after the failure to verify the rollback (it should print 200.0).
    Invoice databaseInvoice = invoiceRepository.findById(invoice.getId()).orElseThrow();
    System.out.println("Invoice amount in the database: " + databaseInvoice.getAmount());
  }
}
