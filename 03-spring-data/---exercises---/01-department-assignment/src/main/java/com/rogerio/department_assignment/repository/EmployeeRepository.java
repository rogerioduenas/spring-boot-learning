package com.rogerio.department_assignment.repository;

import com.rogerio.department_assignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
