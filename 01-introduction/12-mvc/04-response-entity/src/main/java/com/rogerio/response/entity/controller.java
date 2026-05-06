package com.rogerio.response.entity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class controller {

  @GetMapping("/hello")
  ResponseEntity<String> hello() {
    return new ResponseEntity<>("Hello World", HttpStatus.OK);
  }

  //custom body
  @GetMapping("/age")
  ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
    if (yearOfBirth > LocalDate.now().getYear()) {
      return new ResponseEntity<>("Year of birt can't be greater than " + LocalDate.now().getYear(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("Age is " + (LocalDate.now().getYear() - yearOfBirth), HttpStatus.OK);
  }

  // custom header
  @GetMapping("/customHeader")
  ResponseEntity<String> customHeader() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("My-Custom-Header", "any Value");

    return new ResponseEntity<>(
        "Custom header set", headers, HttpStatus.OK);
  }

  // easy mode
  @GetMapping("/hello2")
  ResponseEntity<String> hello2() {
    return ResponseEntity.ok("Hello World");
    /*
    BodyBuilder accepted();
    BodyBuilder badRequest();
    BodyBuilder created(java.net.URI location);
    HeadersBuilder<?> noContent();
    HeadersBuilder<?> notFound();
 */
  }
}
