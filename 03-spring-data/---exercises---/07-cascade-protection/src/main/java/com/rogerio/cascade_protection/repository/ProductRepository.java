package com.rogerio.cascade_protection.repository;

import com.rogerio.cascade_protection.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
