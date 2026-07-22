package com.rogerio.course_enrollment.service;

import com.rogerio.course_enrollment.model.Course;
import com.rogerio.course_enrollment.model.Student;
import com.rogerio.course_enrollment.repository.CourseRepository;
import com.rogerio.course_enrollment.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;

  public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
  }

  @Transactional
  public void enrollStudentInCourse(Long studentId, Long courseId) {
    Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new RuntimeException("student not found"));
    Course course = courseRepository.findById(courseId)
        .orElseThrow(() -> new RuntimeException("course not found"));

    student.addCourse(course);
  }
}

