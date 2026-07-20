package com.rogerio.department_assignment.repository;

import com.rogerio.department_assignment.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{}
