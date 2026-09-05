package com.rogerio.end_to_end;

import com.rogerio.end_to_end.entity.Product;
import com.rogerio.end_to_end.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductE2ETest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private ProductRepository repository;

  @AfterEach
  void tearDown() {
    repository.deleteAll();
  }

  @Test
  @DisplayName("E2E: Should successfully register a product via the full workflow and verify it in the database")
  void shouldCreateProductEndToEnd() {
    Product inputProduct = new Product(null, "Keyboard", new BigDecimal("350.00"));

    ResponseEntity<Product> response = restTemplate.postForEntity("/products", inputProduct, Product.class);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody());
    assertNotNull(response.getBody().getId());
    assertEquals("Keyboard", response.getBody().getName());

    Long createdId = response.getBody().getId();
    Optional<Product> productInDb = repository.findById(createdId);

    assertTrue(productInDb.isPresent());
    assertEquals("Keyboard", productInDb.get().getName());
    assertEquals(0, new BigDecimal("350.00").compareTo(productInDb.get().getPrice()));
  }

  @Test
  @DisplayName("E2E: Should successfully retrieve a product by ID")
  void shouldGetProductByIdEndToEnd() {
    Product existingProduct = new Product(null, "Monitor", new BigDecimal("1200.00"));
    Product savedInDb = repository.save(existingProduct);
    Long idToFind = savedInDb.getId();

    ResponseEntity<Product> response = restTemplate.getForEntity("/products/" + idToFind, Product.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(idToFind, response.getBody().getId());
    assertEquals("Monitor", response.getBody().getName());
    assertEquals(0, new BigDecimal("1200.00").compareTo(response.getBody().getPrice()));
  }
}
