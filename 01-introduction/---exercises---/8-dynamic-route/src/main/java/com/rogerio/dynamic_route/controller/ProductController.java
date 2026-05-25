package com.rogerio.dynamic_route.controller;

import com.rogerio.dynamic_route.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/categories/{main}")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/subcategories/{sub}/{productName}")
  public ResponseEntity<Map<String, String>> getProductPath(@PathVariable Map<String, String> pathVariables) {
    Map<String, String> result = productService.processProductPath(pathVariables);
    return ResponseEntity.ok(result);
  }
}
