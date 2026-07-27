package com.rogerio.derived_query.repository;

import com.rogerio.derived_query.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategory_NameIgnoreCase(String name);
}
