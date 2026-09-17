package com.rogerio.permitall_vs_webignoring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/permit-all")
  public ResponseEntity<String> permitAllEndpoint() {
    return ResponseEntity.ok("Passed through the security filters. (PermitAll)");
  }

  @GetMapping("/web-ignore")
  public ResponseEntity<String> webIgnoringEndpoint() {
    return ResponseEntity.ok("Completely ignored Spring Security. (WebIgnoring)");
  }
}