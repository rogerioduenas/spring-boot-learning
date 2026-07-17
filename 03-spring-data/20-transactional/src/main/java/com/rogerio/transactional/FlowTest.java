package com.rogerio.transactional;

import com.rogerio.transactional.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlowTest implements CommandLineRunner {

  private final EmployeeService employeeService;

  public FlowTest(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @Override
  public void run(String... args) throws Exception {

    // --- TEST 1: The Proxy Error (Self-invocation) ---
    try {
      System.out.println("\n----- parentMethod() -----");
      employeeService.parentMethod();
    } catch (Exception e) {
      System.out.println("[Exception Caught] Test 1: " + e.getMessage());
    }

    // --- TEST 2: Checked Exception (No rollbackFor) ---
    try {
      System.out.println("\n----- checkedExceptionMethod() -----");
      employeeService.checkedExceptionMethod();
    } catch (Exception e) {
      System.out.println("[Exception Caught] Test 2: " + e.getMessage());
    }

    // --- TEST 3: Checked Exception Fix (With rollbackFor) ---
    try {
      System.out.println("\n----- checkedExceptionMethodCorrect() -----");
      employeeService.checkedExceptionMethodCorrect();
    } catch (Exception e) {
      System.out.println("[Exception Caught] Test 3: " + e.getMessage());
    }
  }
}
