package com.rogerio.entity_lifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlowTest implements CommandLineRunner {

  private final UserService userService;

  public FlowTest(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void run(String... args) {
    System.out.println("--- GETTING INTO THE FLOW ---");
    User user = new User();
    user.setName("John Doe");
    System.out.printf("The ID returned by your method was: %d%n",
        userService.saveUser(user));
    System.out.println("-------------------------");
  }
}
