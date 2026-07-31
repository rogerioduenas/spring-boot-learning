package com.rogerio.product_registration.service;

import com.rogerio.product_registration.dto.ProductRequestDTO;
import com.rogerio.product_registration.dto.ProductResponseDTO;
import com.rogerio.product_registration.exception.CategoryNotFound;
import com.rogerio.product_registration.mapper.ProductMapper;
import com.rogerio.product_registration.model.Category;
import com.rogerio.product_registration.model.Product;
import com.rogerio.product_registration.repository.CategoryRepository;
import com.rogerio.product_registration.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  private final CategoryRepository categoryRepository;
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository, ProductMapper productMapper) {
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Transactional
  public ProductResponseDTO registerProduct(ProductRequestDTO productRequestDTO) {
    Category category = findCategoryById(productRequestDTO.categoryId());
    Product product = productMapper.toEntity(productRequestDTO, category);
    Product savedProduct = productRepository.save(product);
    return productMapper.toResponseDTO(savedProduct);
  }

  private Category findCategoryById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new CategoryNotFound(String.format("Category with id %s not found", id)));
  }
}
