package com.rogerio.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final GreetingService greetingService;
  private final String name;
  private final String msg;

  public GreetingController(
      GreetingService greetingService,
      @Value("${app.user-name}") String name,
      @Value("${app.welcome-msg}") String msg) {
    this.greetingService = greetingService;
    this.name = name;
    this.msg = msg;
  }

  @GetMapping("/test-config")
  public String testConfig() {
    return greetingService.getGreeting(name, msg);
  }
}
