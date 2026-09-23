package com.rogerio.basic_role_based_access_control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

  @GetMapping("/public/hello")
  public String publicAccess() {
    return "Public Access Granted";
  }

  @GetMapping("/user/hello")
  public String userAccess() {
    return "Standard User Access (ROLE_USER)";
  }

  @GetMapping("/admin/hello")
  public String adminAccess() {
    return "Administrator Access (ROLE_ADMIN)";
  }
}
