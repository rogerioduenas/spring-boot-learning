package com.rogerio.batch_update;

import com.rogerio.batch_update.model.Category;
import com.rogerio.batch_update.model.Product;
import com.rogerio.batch_update.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final ProductRepository productRepository;

  public ExerciseRunner(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Category category = new Category("Food");

    List<Product> products = List.of(
        new Product("Tomato", 6.0, category),
        new Product("Hamburger", 10.0, category),
        new Product("Cheese", 5.0, category)
    );
    productRepository.saveAll(products);

    int rowsUpdated = productRepository.applyDiscountToCategory(category.getId());
    System.out.printf("Rows updated: %s%n", rowsUpdated);

    productRepository.findById(1L).ifPresent(p ->
        System.out.printf("New tomato price: %s%n", p.getPrice())
    );
  }
}
