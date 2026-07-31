package com.rogerio.product_registration.controller;

import com.rogerio.product_registration.dto.ProductRequestDTO;
import com.rogerio.product_registration.dto.ProductResponseDTO;
import com.rogerio.product_registration.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
    ProductResponseDTO productResponseDTO = productService.registerProduct(productRequestDTO);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(productResponseDTO.id())
        .toUri();

    return ResponseEntity.created(uri).body(productResponseDTO);
  }
}
