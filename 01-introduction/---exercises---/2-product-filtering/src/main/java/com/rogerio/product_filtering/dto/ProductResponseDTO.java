package com.rogerio.product_filtering.dto;

import com.rogerio.product_filtering.model.ProductCategory;

public record ProductResponseDTO(Long id, String name, ProductCategory category, Double price) {
}
