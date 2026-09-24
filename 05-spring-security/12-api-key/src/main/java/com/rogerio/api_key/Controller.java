package com.rogerio.api_key;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/public/ping")
  public String publicEndpoint() {
    return "Public access allowed";
  }

  @GetMapping("/api/data")
  public String protectedEndpoint() {
    return "Private access granted with valid API Key";
  }
}
