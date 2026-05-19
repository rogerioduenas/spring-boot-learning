package com.rogerio.custom.error;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class Controller {

  @PostMapping("/argument-not-valid")
  public ResponseEntity<String> errorTest(@Valid @RequestBody UserDTO dto) {
    return ResponseEntity.ok("Valid data!");
  }

  @GetMapping("/parameter")
  public ResponseEntity<String> parameterTest(@RequestParam("name") String name) {
    return ResponseEntity.ok(String.format("Parameter is valid!%nName: %s!", name));
  }

  @GetMapping("/type/{id}")
  public ResponseEntity<String> typeTest(@PathVariable("id") Long id) {
    return ResponseEntity.ok("ID received: " + id);
  }

  @GetMapping("/wrong-method")
  public ResponseEntity<String> wrongMethod() {
    return ResponseEntity.ok(String.format("You've used a correct method! (GET)"));
  }

  @PostMapping("/wrong-media-type")
  public ResponseEntity<String> wrongMediaType(@Valid @RequestBody UserDTO dto) {
    return ResponseEntity.ok("You've used a correct media type!");
  }

  @GetMapping("/stupid-error")
  public ResponseEntity<String> forcedInternalError() {
    int errorProposal = 10 / 0;

    return ResponseEntity.ok("It never will be read: " + errorProposal);
  }
}
