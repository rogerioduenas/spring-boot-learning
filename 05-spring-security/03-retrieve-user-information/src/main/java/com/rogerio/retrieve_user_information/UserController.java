package com.rogerio.retrieve_user_information;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping("/me")
  public String getMyUsername(@AuthenticationPrincipal UserDetails userDetails) {
    return "Logged-in user: " + userDetails.getUsername();
  }
}
