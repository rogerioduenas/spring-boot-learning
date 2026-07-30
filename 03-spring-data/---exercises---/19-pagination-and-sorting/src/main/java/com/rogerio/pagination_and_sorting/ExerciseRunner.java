package com.rogerio.pagination_and_sorting;

import com.rogerio.pagination_and_sorting.model.Product;
import com.rogerio.pagination_and_sorting.repository.ProductRepository;
import com.rogerio.pagination_and_sorting.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final ProductRepository productRepository;
  private final ProductService productService;

  public ExerciseRunner(ProductRepository productRepository, ProductService productService) {
    this.productRepository = productRepository;
    this.productService = productService;
  }

  @Override
  public void run(String... args) throws Exception {
    for (int i = 0; i < 10; i++) {
      productRepository.save(new Product(String.format("Product %d", i), 100.00));
    }
    productService.getProductsPaged(0, 5, "name").forEach(System.out::println);

  }
}
