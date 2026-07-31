package com.rogerio.product_registration.mapper;

import com.rogerio.product_registration.dto.ProductRequestDTO;
import com.rogerio.product_registration.dto.ProductResponseDTO;
import com.rogerio.product_registration.model.Category;
import com.rogerio.product_registration.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public Product toEntity(ProductRequestDTO dto, Category category) {
    return new Product(dto.name(), dto.price(), category);
  }

  public ProductResponseDTO toResponseDTO(Product entity) {
    return new ProductResponseDTO(
        entity.getId(),
        entity.getName(),
        entity.getPrice(),
        entity.getCategory().getName());
  }
}
