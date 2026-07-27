package com.rogerio.n_plus_one.repository;

import com.rogerio.n_plus_one.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
