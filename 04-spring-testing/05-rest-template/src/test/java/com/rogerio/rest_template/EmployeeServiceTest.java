package com.rogerio.rest_template;

import com.rogerio.rest_template.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private EmployeeService empService;

  @Test
  @DisplayName("getForEntity - Should return an employee when the HTTP call is successful.")
  void givenMockingIsDoneByMockito_whenGetForEntityIsCalled_thenReturnMockedObject() {
    Long employeeId = 1L;
    Employee mockEmployee = new Employee(1L, "Mike");
    ResponseEntity<Employee> responseEntity = new ResponseEntity<>(mockEmployee, HttpStatus.OK);

    given(restTemplate.getForEntity("http://localhost:8080/employee/" + employeeId, Employee.class))
        .willReturn(responseEntity);

    Employee result = empService.getEmployeeWithGetForEntity(employeeId);

    assertEquals(mockEmployee, result);
  }

  @Test
  @DisplayName("exchange - Should create and return the employee upon a successful HTTP POST call.")
  void givenValidEmployee_whenCreateEmployeeWithExchange_thenReturnCreatedEmployee() {
    Employee inputEmployee = new Employee(null, "Mike");
    Employee createdEmployee = new Employee(1L, "Mike");

    HttpEntity<Employee> requestEntity = new HttpEntity<>(inputEmployee);
    ResponseEntity<Employee> responseEntity = new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);

    given(restTemplate.exchange(
        "http://localhost:8080/employee",
        HttpMethod.POST,
        requestEntity,
        Employee.class
    )).willReturn(responseEntity);

    Employee result = empService.createEmployeeWithExchange(inputEmployee);

    assertEquals(createdEmployee, result);
  }
}
