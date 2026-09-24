package com.rogerio.custom_annotations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controller {

  @GetMapping
  @CanReadUser
  public ResponseEntity<String> findAll() {
    return ResponseEntity.ok("User list accessed successfully!");
  }

  @DeleteMapping("/{id}")
  @IsAdmin
  public ResponseEntity<String> delete(@PathVariable Long id) {
    return ResponseEntity.ok("User " + id + " removed by an Admin!");
  }
}
