package com.rogerio.cascade_protection.service;

import com.rogerio.cascade_protection.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional
  public void deleteProduct(Long productId){
    productRepository.deleteById(productId);
  }
}
