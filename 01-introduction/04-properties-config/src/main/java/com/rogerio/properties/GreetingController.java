package com.rogerio.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {

  @Value("${app.user-name}")
  private String name;

  @Value("${app.welcome-msg}")
  private String msg;

  @Autowired // --- @Service ---
  private GreetingService greetingService;

  @Autowired // --- @Bean ---
  private ObjectMapper objectMapper;

  @GetMapping("/test-config")
  public String testConfig() {
    return greetingService.getGreeting(name, msg);
  }
}
