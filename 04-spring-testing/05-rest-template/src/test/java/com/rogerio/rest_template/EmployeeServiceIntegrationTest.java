package com.rogerio.rest_template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rogerio.rest_template.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(EmployeeService.class)
public class EmployeeServiceIntegrationTest {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MockRestServiceServer mockServer;

  @Test
  @DisplayName("Should simulate an HTTP server response using MockRestServiceServer.")
  void givenMockRestServiceServer_whenGetForEntityIsCalled_thenReturnMockedObject() throws Exception {
    Long employeeId = 1L;
    Employee expectedEmployee = new Employee(employeeId, "Mike");

    mockServer.expect(once(), requestTo("http://localhost:8080/employee/" + employeeId))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess(objectMapper.writeValueAsString(expectedEmployee), MediaType.APPLICATION_JSON));

    Employee result = employeeService.getEmployeeWithGetForEntity(employeeId);

    mockServer.verify();
    assertEquals(expectedEmployee, result);
  }

  @Test
  @DisplayName("exchange (POST) - Should validate payload submission and CREATED status.")
  void givenMockRestServiceServer_whenCreateEmployeeWithExchange_thenReturnCreatedEmployee() throws Exception {
    Employee inputEmployee = new Employee(null, "Mike");
    Employee createdEmployee = new Employee(1L, "Mike");

    mockServer.expect(once(), requestTo("http://localhost:8080/employee"))
        .andExpect(method(HttpMethod.POST))
        .andExpect(content().json(objectMapper.writeValueAsString(inputEmployee)))
        .andRespond(withStatus(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(objectMapper.writeValueAsString(createdEmployee)));

    Employee result = employeeService.createEmployeeWithExchange(inputEmployee);

    mockServer.verify();
    assertEquals(createdEmployee, result);
  }
}
