package com.rogerio.hello_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperController {

  private final StupidRepository repository;

  public SuperController(StupidRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/send")
  public String sendRegister() {
    StupidRegister register = new StupidRegister("stupid register");

    StupidRegister saved = repository.save(register);

    return "Record saved successfully! ID: " + saved.getId() + " - Message: " + saved.getMessage();
  }
}
