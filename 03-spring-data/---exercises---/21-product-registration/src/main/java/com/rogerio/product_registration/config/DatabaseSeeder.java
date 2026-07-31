package com.rogerio.product_registration.config;

import com.rogerio.product_registration.model.Category;
import com.rogerio.product_registration.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final CategoryRepository categoryRepository;

  public DatabaseSeeder(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (categoryRepository.count() == 0) {
      categoryRepository.save(new Category("Electronics"));
    }
  }
}
