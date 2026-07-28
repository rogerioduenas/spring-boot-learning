package com.rogerio.batch_update.repository;

import com.rogerio.batch_update.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Modifying(clearAutomatically = true)
  @Query("UPDATE Product p SET p.price = p.price * 0.9 WHERE p.category.id = :categoryId")
  int applyDiscountToCategory(Long categoryId);
}
