package com.rogerio.custom_filter_chain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/login")
  public String login() {
    return "login processed";
  }
}
