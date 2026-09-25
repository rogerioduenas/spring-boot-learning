package com.rogerio.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

  private final JwtService jwtService;

  public Controller(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  @PostMapping("/auth/login")
  public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
    if ("user@email.com".equals(request.username()) && "password123".equals(request.password())) {
      String token = jwtService.generateToken(request.username());
      return ResponseEntity.ok(Map.of("token", token));
    }
    return ResponseEntity.status(401).build();
  }

  @GetMapping("/data")
  public ResponseEntity<Map<String, String>> getProtectedData() {
    return ResponseEntity.ok(Map.of("message", "Access allowed with JWT"));
  }

  public record LoginRequest(String username, String password) {
  }
}