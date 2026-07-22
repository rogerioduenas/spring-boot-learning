package com.rogerio.cascade_protection;

import com.rogerio.cascade_protection.model.Category;
import com.rogerio.cascade_protection.model.Product;
import com.rogerio.cascade_protection.repository.ProductRepository;
import com.rogerio.cascade_protection.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final ProductService productService;
  private final ProductRepository productRepository;

  public ExerciseRunner(ProductService productService, ProductRepository productRepository) {
    this.productService = productService;
    this.productRepository = productRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Category category = new Category("Electronics");

    Product p1 = new Product("Smartphone", category);
    Product p2 = new Product("Laptop", category);

    productRepository.saveAll(List.of(p1, p2));

    productService.deleteProduct(p1.getId());
  }
}
