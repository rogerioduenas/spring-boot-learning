package com.rogerio.inventory_validation.repository;

import com.rogerio.inventory_validation.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

  private final List<Product> products = new ArrayList<>(List.of(
      new Product(1L, "Product 1", 10),
      new Product(2L, "Product 2", 20),
      new Product(3L, "Product 3", 30)
  ));

  public Optional<Product> findById(final Long id) {
    return products.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();
  }
}
