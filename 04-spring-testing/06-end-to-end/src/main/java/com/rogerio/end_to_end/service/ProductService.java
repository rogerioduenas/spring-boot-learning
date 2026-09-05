package com.rogerio.end_to_end.service;

import com.rogerio.end_to_end.entity.Product;
import com.rogerio.end_to_end.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Product save(Product product) {
    return repository.save(product);
  }

  public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));
  }
}
