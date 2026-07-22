package com.rogerio.course_enrollment.repository;

import com.rogerio.course_enrollment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
