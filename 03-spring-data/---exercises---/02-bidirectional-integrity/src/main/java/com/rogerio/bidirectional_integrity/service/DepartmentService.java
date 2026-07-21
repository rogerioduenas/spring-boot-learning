package com.rogerio.bidirectional_integrity.service;

import com.rogerio.bidirectional_integrity.model.Department;
import com.rogerio.bidirectional_integrity.model.Employee;
import com.rogerio.bidirectional_integrity.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Transactional
  public Department addEmployeeToDepartment(Long departmentId, String employeeName) {
    Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department with id %s not found".formatted(departmentId)));

    Employee employee = new Employee(employeeName);
    department.addEmployee(employee);

    return departmentRepository.save(department);
  }
}
