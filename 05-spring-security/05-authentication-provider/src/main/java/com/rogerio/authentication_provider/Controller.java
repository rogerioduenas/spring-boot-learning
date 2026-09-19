package com.rogerio.authentication_provider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

  @GetMapping("/login")
  public ResponseEntity<String> getProtectedResource() {
    return ResponseEntity.ok("Access Allowed");
  }
}
