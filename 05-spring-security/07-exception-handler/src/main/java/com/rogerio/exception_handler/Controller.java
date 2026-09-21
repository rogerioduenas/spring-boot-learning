package com.rogerio.exception_handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/api/protected")
  public ResponseEntity<String> protectedEndpoint() {
    return ResponseEntity.ok("Access to the protected resource is permitted");
  }
}
