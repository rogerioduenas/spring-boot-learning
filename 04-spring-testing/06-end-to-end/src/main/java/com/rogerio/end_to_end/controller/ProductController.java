package com.rogerio.end_to_end.controller;

import com.rogerio.end_to_end.entity.Product;
import com.rogerio.end_to_end.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product saved = service.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable Long id) {
    Product product = service.findById(id);
    return ResponseEntity.ok(product);
  }
}
