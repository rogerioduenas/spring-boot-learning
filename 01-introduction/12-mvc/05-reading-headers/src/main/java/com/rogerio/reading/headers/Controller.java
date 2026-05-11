package com.rogerio.reading.headers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Controller {

  //simple and old
  @GetMapping("/greeting")
  public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
    return new ResponseEntity<>("Hello " + language, HttpStatus.OK);
  }

  // aleatory header key and number value
  @GetMapping("/double")
  public ResponseEntity<String> doubleNumber(@RequestHeader("french-fries") int myNumber) {
    return new ResponseEntity<>(String.format("%d * 2 = %d",
        myNumber, (myNumber * 2)), HttpStatus.OK);
  }

  // return only a status code
  @GetMapping("/listHeaders")
  public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
    headers.forEach((key, value) -> {
      System.out.println(String.format("Header '%s': %s", key, value));
    });
    return ResponseEntity.ok().build();
  }

  // return a response at the body
  // obs: ***MultiValueMap*** is a spring abstraction of Map with multiple values for each key. Something like this: Map<String, List<String>>
  @GetMapping("/multiValue")
  public ResponseEntity<String> multiValue(
      @RequestHeader MultiValueMap<String, String> headers) {
    headers.forEach((key, value) -> {
      System.out.println(String.format(
          "Header: '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
    });

    return ResponseEntity.ok("Listed headers: " + headers.size());
  }

  // return URL
  @GetMapping("/getBaseUrl")
  public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
    InetSocketAddress host = headers.getHost();
    String url = "http://" + host.getHostName() + ":" + host.getPort();
    return ResponseEntity.ok("Base URL: " + url);
  }

  // optional header
  @GetMapping("/isRequiredHeader")
  public ResponseEntity<String> isRequiredHeader(
      @RequestHeader(value = "optional-header", required = false) String optionalHeader) {
    return ResponseEntity.ok(String.format("Was the optional header present? %s!",
        (optionalHeader == null ? "No" : "Yes")));
  }

  // optional header with a default value
  @GetMapping("/default")
  public ResponseEntity<String> defaultHeader(
      @RequestHeader(value = "optional-header", defaultValue = "I'm default") String optionalHeader) {
    return ResponseEntity.ok(String.format("Optional Header is: %s", optionalHeader));
  }
}
