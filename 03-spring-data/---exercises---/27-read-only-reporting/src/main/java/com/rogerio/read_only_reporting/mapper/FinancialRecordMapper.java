package com.rogerio.read_only_reporting.mapper;

import com.rogerio.read_only_reporting.dto.FinancialRecordResponseDTO;
import com.rogerio.read_only_reporting.model.FinancialRecord;
import org.springframework.stereotype.Component;

@Component
public class FinancialRecordMapper {

  public FinancialRecordResponseDTO toDTO(FinancialRecord financialRecord) {
    return new FinancialRecordResponseDTO(
        financialRecord.getId(),
        financialRecord.getDescription(),
        financialRecord.getAmount()
    );
  }
}
