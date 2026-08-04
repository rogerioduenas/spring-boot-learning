package com.rogerio.transaction_rollback.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequestDTO(

    @NotNull(message = "Id can't be null")
    Long fromWalletId,

    @NotNull(message = "Id can't be null")
    Long toWalletId,

    @NotNull(message = "Amount can't be null")
    @Positive(message = "Amount must be greater than zero")
    BigDecimal amount) {}
