package com.rogerio.read_only_reporting.dto;

import java.math.BigDecimal;

public record FinancialRecordResponseDTO(Long id, String description, BigDecimal amount) {
}
