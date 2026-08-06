package com.rogerio.read_only_reporting.repository;

import com.rogerio.read_only_reporting.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
}
