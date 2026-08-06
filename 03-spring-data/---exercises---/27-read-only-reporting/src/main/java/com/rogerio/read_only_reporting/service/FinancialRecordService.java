package com.rogerio.read_only_reporting.service;

import com.rogerio.read_only_reporting.dto.FinancialRecordResponseDTO;
import com.rogerio.read_only_reporting.mapper.FinancialRecordMapper;
import com.rogerio.read_only_reporting.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinancialRecordService {

  private final FinancialRecordRepository financialRecordRepository;
  private final FinancialRecordMapper financialRecordMapper;

  public FinancialRecordService(FinancialRecordRepository financialRecordRepository, FinancialRecordMapper financialRecordMapper) {
    this.financialRecordRepository = financialRecordRepository;
    this.financialRecordMapper = financialRecordMapper;
  }

  @Transactional(readOnly = true)
  public List<FinancialRecordResponseDTO> findAll() {
    return financialRecordRepository.findAll().stream()
        .peek(fr -> fr.setDescription("FORCED_UPDATE_READ_ONLY_TEST"))
        .map(financialRecordMapper::toDTO)
        .toList();
  }
}
