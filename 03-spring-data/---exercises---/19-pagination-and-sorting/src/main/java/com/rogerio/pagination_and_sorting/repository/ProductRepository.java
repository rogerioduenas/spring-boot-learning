package com.rogerio.pagination_and_sorting.repository;

import com.rogerio.pagination_and_sorting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
