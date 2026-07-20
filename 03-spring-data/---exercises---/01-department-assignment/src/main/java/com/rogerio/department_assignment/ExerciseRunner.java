package com.rogerio.department_assignment;

import com.rogerio.department_assignment.model.Department;
import com.rogerio.department_assignment.repository.DepartmentRepository;
import com.rogerio.department_assignment.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final DepartmentRepository departmentRepository;
  private final EmployeeService employeeService;

  public ExerciseRunner(DepartmentRepository departmentRepository, EmployeeService employeeService) {
    this.departmentRepository = departmentRepository;
    this.employeeService = employeeService;
  }

  @Override
  public void run(String... args) throws Exception {
    Department dev = departmentRepository.save(new Department("Development"));
    employeeService.save("Mike", dev.getId());

    employeeService.save("Mike", 999L);
  }
}
