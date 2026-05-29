package com.rogerio.inventory_validation.service;

import com.rogerio.inventory_validation.dto.ProductResponseDTO;
import com.rogerio.inventory_validation.exception.InsufficientStockException;
import com.rogerio.inventory_validation.exception.ProductNotFoundException;
import com.rogerio.inventory_validation.model.Product;
import com.rogerio.inventory_validation.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public ProductResponseDTO sellProduct(final Long id, final Integer quantity) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product not found!"));

    if (product.getQuantity() < quantity) {
      throw new InsufficientStockException("Insufficient stock!");
    }

    product.setQuantity(product.getQuantity() - quantity);

    return new ProductResponseDTO(
        product.getId(),
        product.getName(),
        product.getQuantity());
  }
}
