package com.rogerio.library_checkout_flow.repository;

import com.rogerio.library_checkout_flow.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
}
