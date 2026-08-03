package com.rogerio.catalog_paging.dto;

import com.rogerio.catalog_paging.model.Product;

public record ProductResponseDTO(
    Long id,
    String name,
    Double price,
    String categoryName
) {
  public ProductResponseDTO(Product product) {
    this(
        product.getId(),
        product.getName(),
        product.getPrice(),
        product.getCategory().getName());
  }
}
