package com.rogerio.catalog_paging.repository;

import com.rogerio.catalog_paging.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
