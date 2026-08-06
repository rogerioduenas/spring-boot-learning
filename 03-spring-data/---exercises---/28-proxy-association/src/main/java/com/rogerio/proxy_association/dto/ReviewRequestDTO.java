package com.rogerio.proxy_association.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ReviewRequestDTO(
    @NotBlank(message = "Content is required")
    String content,

    @NotNull(message = "Book ID is required")
    @Positive(message = "Book ID must be positive")
    Long bookId) {
}
