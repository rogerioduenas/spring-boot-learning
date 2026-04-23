package com.rogerio.request.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Routes {

  // HTTP Method
  //  @RequestMapping(value = "/ex", method = RequestMethod.GET)
  //  or only
  @GetMapping("/ex")
  public String getSimpleExample() {
    return "GET example";
  }

  // HTTP Headers Attribute
  //  @RequestMapping(value = "/ex/header", headers = "key=val", method = GET)
  //  or only
  @GetMapping(value = "/ex/header", headers = "key=val")
  // for multiple attributes: { "key1=val1", "key2=val2" }
  public String getExampleWithHeaders() {
    return "GET example with headers Attribute";
  }

  // Consumes
  @PostMapping(value = "/save-book", consumes = "application/json")
  public String saveBook(@RequestBody Book book) {
    return book.title() + " book received successfully!";
  }

  // Produces
  @GetMapping(value = "/book-json", produces = "application/json")
  // produces = { "application/json", "application/xml" }
  public Book getBook() {
    return new Book(1L, "Spring Boot");
  }

  // Path Variables
  @GetMapping(value = "/ex/{id}")
  public String getSimplePathWithPathVariable(@PathVariable("id") Long id) {
    return "GET example with path variable {id}: " + id;
  }

  // Multiple @PathVariable
  @GetMapping(value = "/ex/{var1}/{var2}")
  public String getSimplePathWithMultipleVariables(@PathVariable("var1") Long var1, @PathVariable Long var2) {
    return String.format("var1: %d, var2: %d", var1, var2);
  }

  // Multiple @PathVariable using Map<?,?>
  @GetMapping("/ex2/{id}/{name}")
  public String getEmployeesByIdAndNameWithMap(@PathVariable Map<String, String> pathVarsMap) {
    String id = pathVarsMap.get("id");
    String name = pathVarsMap.get("name");

    if (id != null && name != null) {
      return "ID: " + id + ", name: " + name;
    }
    return "Missing Parameters";
  }

  // Multiple rotes with @PathVariable not required
  @GetMapping(value = { "/ex3", "/ex3/{id}" })
  public String getIdWithRequiredFalse(@PathVariable(required = false) String id) {
    if (id != null) {
      return "ID: " + id;
    } else {
      return "ID missing";
    }
  }

  // Regex
  @GetMapping(value = "/ex/regex/{numericId:[\\d]+}")
  public String getSimplePathWithRegex(@PathVariable long numericId) {
    return "GET example with Regex: " + numericId;
  }

  // Request Parameters
  @GetMapping(value = "/ex/rp") // http://localhost:8080/ex/rp?id=100
  public String getPathWithRequestParam(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // another way
  @GetMapping(value = "/ex/rp2", params = "id") // http://localhost:8080/ex/rp2?id=100
  public String getPathWithRequestParam2(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // Multiple params
  @GetMapping(value = "/ex/rp3", params = {"id", "second"})
  // http://localhost:8080/ex/rp3?id=100&second=
  public String getPathWithMultipleRequestParam(@RequestParam long id) {
    return "GET example with request parameters: " + id;
  }

  // Therefore, the 'second' parameter is indeed optional.
  @GetMapping(value = "/ex/rp4", params = {"id"}) // http://localhost:8080/ex/rp4?id=100
  public String getPathWithMultipleRequestParam2(
      @RequestParam long id,
      @RequestParam(required = false) String second) {
    return "GET example: " + id + " Second: " + second;
  }

  // Default value
  @GetMapping("/ex/rp5")
  public String getPathWithRequestParamDefaultValue(@RequestParam(defaultValue = "test") String id) {
    return "ID: " + id;
  }

  // multiple parameters without defining their names using MAP
  @PostMapping("/ex/all")
  // http://localhost:8080/ex/all?id=1name=mike...
  public String updateFoos(@RequestParam Map<String,String> allParams) {
    return "Parameters are " + allParams.entrySet();
  }

  // a parameter with multiple values
  @GetMapping("/ex/all2")
  public String getFoos(@RequestParam List<String> id) {
    return "IDs are " + id;
  }
}
