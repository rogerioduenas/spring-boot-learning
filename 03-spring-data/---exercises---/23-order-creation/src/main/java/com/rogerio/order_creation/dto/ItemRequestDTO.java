package com.rogerio.order_creation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemRequestDTO(
    @NotBlank(message = "Product name is required")
    String productName,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    Double price
) {}
