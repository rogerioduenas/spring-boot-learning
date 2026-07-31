package com.rogerio.product_registration.dto;

public record ProductResponseDTO(
    Long id,
    String name,
    Double price,
    String categoryName
) {}
