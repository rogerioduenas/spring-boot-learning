package com.rogerio.product_registration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequestDTO(
    @NotBlank(message = "The product name cannot be empty or null.")
    @Size(min = 2, max = 100, message = "The product name must be between 2 and 100 characters long.")
    String name,

    @NotNull(message = "The product price is mandatory.")
    @Positive(message = "The product price must be greater than zero.")
    Double price,

    @NotNull(message = "The category ID is required.")
    Long categoryId){}
