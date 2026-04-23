package com.rogerio.request.mapping;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PathVariablesController {

  // Basic HTTP GET method
  @GetMapping
  public String getSimpleExample() {
    return "GET example";
  }

  // Simple path variable mapping
  @GetMapping("/{id}")
  public String getSimplePathWithPathVariable(@PathVariable("id") Long id) {
    return "GET example with path variable {id}: " + id;
  }

  // Mapping multiple path variables
  @GetMapping("/{var1}/{var2}")
  public String getSimplePathWithMultipleVariables(@PathVariable("var1") Long var1, @PathVariable Long var2) {
    return String.format("var1: %d, var2: %d", var1, var2);
  }

  // Extracting multiple path variables using a Map
  @GetMapping("/vars/{id}/{name}")
  public String getEmployeesByIdAndNameWithMap(@PathVariable Map<String, String> pathVarsMap) {
    String id = pathVarsMap.get("id");
    String name = pathVarsMap.get("name");
    return (id != null && name != null) ? "ID: " + id + ", name: " + name : "Missing Parameters";
  }

  // Optional path variable using multiple path mapping
  @GetMapping(value = { "/opt", "/opt/{id}" })
  public String getIdWithRequiredFalse(@PathVariable(required = false) String id) {
    return (id != null) ? "ID: " + id : "ID missing";
  }

  // Path variable restricted by regular expression (numeric only)
  @GetMapping("/regex/{numericId:[\\d]+}")
  public String getSimplePathWithRegex(@PathVariable long numericId) {
    return "GET example with Regex: " + numericId;
  }
}