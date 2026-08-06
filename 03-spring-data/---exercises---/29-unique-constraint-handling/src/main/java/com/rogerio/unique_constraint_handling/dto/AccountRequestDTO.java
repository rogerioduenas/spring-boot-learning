package com.rogerio.unique_constraint_handling.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountRequestDTO(
    @NotBlank(message = "Email is required")
    String email,

    @NotBlank(message = "Tax ID is required")
    String taxId
) {}
