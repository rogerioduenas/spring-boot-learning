package com.rogerio.transaction_rollback.repository;

import com.rogerio.transaction_rollback.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
