package com.rogerio.derived_query;

import com.rogerio.derived_query.model.Category;
import com.rogerio.derived_query.model.Product;
import com.rogerio.derived_query.repository.ProductRepository;
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
    Category foodCategory = new Category("Food");
    Category carCategory = new Category("Car");

    List<Product> products = List.of(
        new Product("Pizza", foodCategory),
        new Product("Tomato", foodCategory),
        new Product("Ferrari", carCategory)
    );
    productRepository.saveAll(products);

    productRepository.findByCategory_NameIgnoreCase("food")
        .forEach(System.out::println);
  }
}
