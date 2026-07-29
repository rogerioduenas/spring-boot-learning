package com.rogerio.unique_constraints;

import com.rogerio.unique_constraints.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final EmployeeService employeeService;

  public ExerciseRunner(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @Override
  public void run(String... args) throws Exception {
    // To see the error occur, run this twice.
    employeeService.registerEmployee("John", "Doe", "123-456");
  }
}
