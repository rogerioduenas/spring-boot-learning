package com.rogerio.one_to_one_profile.repository;

import com.rogerio.one_to_one_profile.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
