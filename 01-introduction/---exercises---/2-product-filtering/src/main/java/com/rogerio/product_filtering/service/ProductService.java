package com.rogerio.product_filtering.service;

import com.rogerio.product_filtering.model.Product;
import com.rogerio.product_filtering.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

  private final List<Product> products = new ArrayList<>(List.of(
      new Product(1L, "bookName_1", ProductCategory.BOOKS, 99.90),
      new Product(2L, "bookName_2", ProductCategory.BOOKS, 99.90),
      new Product(3L, "movieName_1", ProductCategory.MOVIES, 99.90),
      new Product(4L, "movieName_2", ProductCategory.MOVIES, 99.90)
  ));

  public List<Product> findByCategory(ProductCategory category) {
    return products.stream()
        .filter(p -> category == null || p.category() == category)
        .toList();
  }
}
