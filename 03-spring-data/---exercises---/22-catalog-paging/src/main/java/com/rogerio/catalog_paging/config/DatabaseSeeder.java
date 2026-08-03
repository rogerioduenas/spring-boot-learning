package com.rogerio.catalog_paging.config;

import com.rogerio.catalog_paging.model.Category;
import com.rogerio.catalog_paging.model.Product;
import com.rogerio.catalog_paging.repository.CategoryRepository;
import com.rogerio.catalog_paging.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public DatabaseSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Category category = null;
    if (categoryRepository.count() == 0) {
      category = categoryRepository.save(new Category("Electronics"));
    }

    List<Product> products = List.of(
        new Product("Galaxy S23 Smartphone", 4500.00, category),
        new Product("Dell XPS 13 Laptop", 8500.00, category),
        new Product("Sony Bluetooth Headphones", 1200.00, category),
        new Product("55-Inch 4K Smart TV", 3200.00, category),
        new Product("27-Inch 144Hz Gaming Monitor", 1800.00, category),
        new Product("PlayStation 5 Console", 3900.00, category),
        new Product("iPad Air Tablet", 5200.00, category),
        new Product("Apple Watch Smartwatch", 2800.00, category),
        new Product("JBL Flip 6 Speaker", 650.00, category),
        new Product("Wireless Mechanical Keyboard", 450.00, category)
    );
    if (productRepository.count() < 10) {
      productRepository.saveAll(products);
    }
  }
}
