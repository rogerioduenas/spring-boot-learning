package com.rogerio.web_mvc.controller;

import com.rogerio.web_mvc.entity.Employee;
import com.rogerio.web_mvc.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private EmployeeService service;

  @Test
  @DisplayName("GET /api/employees - Should return list of employees")
  void givenEmployeesExist_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
    Employee alex = new Employee(1L, "Alex");
    given(service.getAllEmployees()).willReturn(List.of(alex));

    mvc.perform(get("/api/employees"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].name").value("Alex"));
  }

  @Test
  @DisplayName("GET /api/employees - Should return 500 Internal Server Error when the service fails")
  void givenServiceFails_whenGetAllEmployees_thenReturnInternalServerError() throws Exception {
    given(service.getAllEmployees())
        .willThrow(new RuntimeException("Database unavailable"));

    mvc.perform(get("/api/employees"))
        .andExpect(status().isInternalServerError());
  }

  @Test
  @DisplayName("GET /api/employees/{id} - Should return employee by ID")
  void givenExistingEmployeeId_whenGetEmployeeById_thenReturnEmployee() throws Exception {
    Employee alex = new Employee(1L, "Alex");
    given(service.getEmployeeById(1L)).willReturn(alex);

    mvc.perform(get("/api/employees/{id}", 1L))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Alex"));
  }

  @Test
  @DisplayName("POST /api/employees - Should create an employee and return 201 Created.")
  void givenValidEmployee_whenCreateEmployee_thenReturnCreatedEmployee() throws Exception {
    Employee input = new Employee(null, "Maria");
    Employee created = new Employee(1L, "Maria");

    given(service.createEmployee(any(Employee.class))).willReturn(created);

    mvc.perform(post("/api/employees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(input)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Maria"));
  }

  @Test
  @DisplayName("PUT /api/employees/{id} - Should be updated employee")
  void givenValidEmployeeAndId_whenUpdateEmployee_thenReturnUpdatedEmployee() throws Exception {
    Employee input = new Employee(null, "Mike");
    Employee updated = new Employee(1L, "Mike");

    given(service.updateEmployee(eq(1L), any(Employee.class)))
        .willReturn(updated);

    mvc.perform(put("/api/employees/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(input)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Mike"));
  }

  @Test
  @DisplayName("DELETE /api/employees/{id} - Should delete employee and return 204 No Content")
  void givenExistingEmployeeId_whenDeleteEmployee_thenReturnNoContent() throws Exception {
    willDoNothing().given(service).deleteEmployee(1L);

    mvc.perform(delete("/api/employees/{id}", 1L))
        .andExpect(status().isNoContent());
  }
}
