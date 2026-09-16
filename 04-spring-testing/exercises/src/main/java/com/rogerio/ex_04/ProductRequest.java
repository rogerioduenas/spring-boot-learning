package com.rogerio.ex_04;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
    @NotBlank(message = "Name is required")
    String name,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    Double price,

    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity must be zero or positive")
    Integer quantityInStock
) {}
