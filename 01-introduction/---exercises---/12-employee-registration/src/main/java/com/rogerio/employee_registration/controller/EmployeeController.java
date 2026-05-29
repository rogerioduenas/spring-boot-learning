package com.rogerio.employee_registration.controller;

import com.rogerio.employee_registration.dto.CreateEmployeeDTO;
import com.rogerio.employee_registration.dto.ResponseEmployeeDTO;
import com.rogerio.employee_registration.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  public ResponseEntity<ResponseEmployeeDTO> createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
    ResponseEmployeeDTO responseEmployeeDTO = employeeService.saveEmployee(createEmployeeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseEmployeeDTO);
  }
}
