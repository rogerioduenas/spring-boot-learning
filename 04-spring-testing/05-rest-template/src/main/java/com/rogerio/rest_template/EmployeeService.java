package com.rogerio.rest_template;

import com.rogerio.rest_template.entity.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

  private final RestTemplate restTemplate;

  public EmployeeService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Employee getEmployeeWithGetForEntity(Long id) {
    ResponseEntity<Employee> response = restTemplate.getForEntity(
        "http://localhost:8080/employee/" + id,
        Employee.class
    );
    return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
  }

  public Employee createEmployeeWithExchange(Employee newEmployee) {
    HttpEntity<Employee> requestEntity = new HttpEntity<>(newEmployee);

    ResponseEntity<Employee> response = restTemplate.exchange(
        "http://localhost:8080/employee",
        HttpMethod.POST,
        requestEntity,
        Employee.class
    );

    return response.getStatusCode() == HttpStatus.CREATED ? response.getBody() : null;
  }
}

