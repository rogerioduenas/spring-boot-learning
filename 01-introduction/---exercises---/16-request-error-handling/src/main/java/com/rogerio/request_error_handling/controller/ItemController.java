package com.rogerio.request_error_handling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

  @GetMapping("/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id) {
    return ResponseEntity.ok().build();
  }
}
