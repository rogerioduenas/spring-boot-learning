package com.rogerio.request.mapping;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RequestParamsController {

  // Filtering request by HTTP Headers
  @GetMapping(value = "/header", headers = "key=123")
  public String getExampleWithHeaders() {
    return "GET example with headers Attribute";
  }

  // Handling JSON input using @RequestBody
  @PostMapping(value = "/save-book", consumes = "application/json")
  public String saveBook(@RequestBody Book book) {
    return book.title() + " book received successfully!";
  }

  // Producing JSON output automatically
  @GetMapping(value = "/book-json", produces = "application/json")
  public Book getBook() {
    return new Book(1L, "Spring Boot");
  }

  // Simple request parameter (Query Param)
  @GetMapping("/rp")
  public String getPathWithRequestParam(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // Mapping based on the presence of a parameter
  @GetMapping(value = "/rp2", params = "id")
  public String getPathWithRequestParam2(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // Requiring multiple specific parameters in the URL
  @GetMapping(value = "/rp3", params = {"id", "second"})
  public String getPathWithMultipleRequestParam(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // Optional request parameter with required = false
  @GetMapping(value = "/rp4", params = {"id"})
  public String getPathWithMultipleRequestParam2(
      @RequestParam long id,
      @RequestParam(required = false) String second) {
    return "GET example: " + id + " Second: " + second;
  }

  // Defining a default value for a request parameter
  @GetMapping("/rp5")
  public String getPathWithRequestParamDefaultValue(@RequestParam(defaultValue = "test") String id) {
    return "ID: " + id;
  }

  // Capturing all query parameters into a Map
  @PostMapping("/all")
  public String updateFoos(@RequestParam Map<String,String> allParams) {
    return "Parameters are " + allParams.entrySet();
  }

  // Handling a single parameter with multiple values as a List
  @GetMapping("/all2")
  public String getFoos(@RequestParam List<String> id) {
    return "IDs are " + id;
  }
}