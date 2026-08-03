package com.rogerio.catalog_paging.controller;

import com.rogerio.catalog_paging.dto.PageResponseDTO;
import com.rogerio.catalog_paging.dto.ProductResponseDTO;
import com.rogerio.catalog_paging.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }


  @GetMapping
  public ResponseEntity<PageResponseDTO<ProductResponseDTO>> getProductsByCategoryId(
      @RequestParam("categoryId") Long categoryId,
      @PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {

    PageResponseDTO<ProductResponseDTO> response = productService.getProductsByCategoryIdPaged(categoryId, pageable);
    return ResponseEntity.ok(response);
  }
}
