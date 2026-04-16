package com.rogerio.properties;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  public String getGreeting(String name, String msg) {
    return String.format("Hello, %s! Day message: %s", name, msg);
  }
}
