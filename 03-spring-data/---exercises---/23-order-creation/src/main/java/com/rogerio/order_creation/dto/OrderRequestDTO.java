package com.rogerio.order_creation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderRequestDTO(
    @NotBlank(message = "Order number is required")
    String orderNumber,

    @NotEmpty(message = "Order must contain at least one item")
    @Valid
    List<ItemRequestDTO> items
) {}
