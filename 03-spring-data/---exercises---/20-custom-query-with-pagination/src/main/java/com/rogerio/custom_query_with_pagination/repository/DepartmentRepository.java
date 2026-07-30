package com.rogerio.custom_query_with_pagination.repository;

import com.rogerio.custom_query_with_pagination.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
