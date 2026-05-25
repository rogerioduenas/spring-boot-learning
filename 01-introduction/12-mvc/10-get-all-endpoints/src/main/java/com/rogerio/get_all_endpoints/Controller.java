package com.rogerio.get_all_endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/my-example-rote-01")
  public String rote01() {
    return "rote 01";
  }

  @GetMapping("/my-example-rote-02")
  public String rote02() {
    return "rote 02";
  }

  @GetMapping("/my-example-rote-03")
  public String rote03() {
    return "rote 03";
  }
}
