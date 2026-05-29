package com.rogerio.inventory_validation.controller;

import com.rogerio.inventory_validation.dto.ProductResponseDTO;
import com.rogerio.inventory_validation.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/{id}")
  public ResponseEntity<ProductResponseDTO> sell(@PathVariable Long id, @RequestParam Integer quantity) {
    ProductResponseDTO productResponseDTO = productService.sellProduct(id, quantity);
    return ResponseEntity.ok(productResponseDTO);
  }
}
