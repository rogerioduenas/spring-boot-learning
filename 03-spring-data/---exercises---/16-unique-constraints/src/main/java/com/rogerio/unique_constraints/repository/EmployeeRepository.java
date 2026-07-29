package com.rogerio.unique_constraints.repository;

import com.rogerio.unique_constraints.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
