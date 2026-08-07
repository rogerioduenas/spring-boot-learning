package com.rogerio.library_checkout_flow.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BorrowRequestDTO(
    @NotNull(message = "Book ID is required")
    @Positive(message = "Book ID must be a positive number")
    Long bookId,

    @NotNull(message = "Borrower ID is required")
    @Positive(message = "Borrower ID must be a positive number")
    Long borrowerId
) {}
