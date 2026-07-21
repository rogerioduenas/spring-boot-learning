package com.rogerio.bidirectional_integrity;

import com.rogerio.bidirectional_integrity.model.Department;
import com.rogerio.bidirectional_integrity.repository.DepartmentRepository;
import com.rogerio.bidirectional_integrity.service.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final DepartmentService departmentService;
  private final DepartmentRepository departmentRepository;

  public ExerciseRunner(DepartmentService departmentService, DepartmentRepository departmentRepository) {
    this.departmentService = departmentService;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Department department = new Department("Engineering");
    departmentRepository.save(department);

    departmentService.addEmployeeToDepartment(department.getId(), "Mike");
  }
}
