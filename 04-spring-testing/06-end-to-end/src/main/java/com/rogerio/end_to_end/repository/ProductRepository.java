package com.rogerio.end_to_end.repository;

import com.rogerio.end_to_end.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
