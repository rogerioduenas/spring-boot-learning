package com.rogerio.web_mvc.controller;

import com.rogerio.web_mvc.service.EmployeeService;
import com.rogerio.web_mvc.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = employeeService.getAllEmployees();
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Employee employee = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(employee);
  }

  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    Employee created = employeeService.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable Long id,
      @RequestBody Employee employee
  ) {
    Employee updated = employeeService.updateEmployee(id, employee);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}
