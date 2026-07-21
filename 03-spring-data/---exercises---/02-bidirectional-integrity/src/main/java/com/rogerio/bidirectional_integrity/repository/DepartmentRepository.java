package com.rogerio.bidirectional_integrity.repository;

import com.rogerio.bidirectional_integrity.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
