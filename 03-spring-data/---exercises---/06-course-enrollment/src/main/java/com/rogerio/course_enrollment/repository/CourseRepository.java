package com.rogerio.course_enrollment.repository;

import com.rogerio.course_enrollment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
