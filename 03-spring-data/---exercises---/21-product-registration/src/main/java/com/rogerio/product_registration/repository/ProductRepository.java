package com.rogerio.product_registration.repository;

import com.rogerio.product_registration.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
