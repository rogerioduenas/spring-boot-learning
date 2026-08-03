package com.rogerio.catalog_paging.service;

import com.rogerio.catalog_paging.dto.PageResponseDTO;
import com.rogerio.catalog_paging.dto.ProductResponseDTO;
import com.rogerio.catalog_paging.exception.CategoryNotFound;
import com.rogerio.catalog_paging.model.Product;
import com.rogerio.catalog_paging.repository.CategoryRepository;
import com.rogerio.catalog_paging.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public PageResponseDTO<ProductResponseDTO> getProductsByCategoryIdPaged(Long categoryId, Pageable pageable) {
    validateCategoryId(categoryId);
    Page<Product> products = productRepository.findAllByCategoryId(categoryId, pageable);
    return new PageResponseDTO<>(products.map(ProductResponseDTO::new));
  }

  private void validateCategoryId(Long categoryId) {
    if (!categoryRepository.existsById(categoryId)) {
      throw new CategoryNotFound(String.format("Category not found with id: %s", categoryId));
    }
  }
}
