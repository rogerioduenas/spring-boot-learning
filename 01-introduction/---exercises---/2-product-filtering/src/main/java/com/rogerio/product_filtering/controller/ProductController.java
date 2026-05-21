package com.rogerio.product_filtering.controller;

import com.rogerio.product_filtering.dto.ProductResponseDTO;
import com.rogerio.product_filtering.model.Product;
import com.rogerio.product_filtering.model.ProductCategory;
import com.rogerio.product_filtering.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<ProductResponseDTO>> getProducts(@RequestParam(required = false) ProductCategory category) {
    List<Product> products = productService.findByCategory(category);
    return ResponseEntity.ok(products.stream()
        .map(p -> new ProductResponseDTO(p.id(), p.name(), p.category(), p.price()))
        .toList());
  }
}
