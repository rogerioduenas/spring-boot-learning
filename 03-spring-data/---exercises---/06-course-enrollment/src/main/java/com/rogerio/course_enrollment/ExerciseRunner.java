package com.rogerio.course_enrollment;

import com.rogerio.course_enrollment.model.Course;
import com.rogerio.course_enrollment.model.Student;
import com.rogerio.course_enrollment.repository.CourseRepository;
import com.rogerio.course_enrollment.repository.StudentRepository;
import com.rogerio.course_enrollment.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final StudentService studentService;
  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;

  public ExerciseRunner(StudentService studentService, StudentRepository studentRepository, CourseRepository courseRepository) {
    this.studentService = studentService;
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Student student = new Student("Mike");
    Course course = new Course("TI");

    Student savedStudent = studentRepository.save(student);
    Course savedCourse = courseRepository.save(course);

    studentService.enrollStudentInCourse(savedStudent.getId(), savedCourse.getId());
  }
}
