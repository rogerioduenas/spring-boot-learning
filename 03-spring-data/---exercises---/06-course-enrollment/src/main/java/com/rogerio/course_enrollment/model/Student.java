package com.rogerio.course_enrollment.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

  @Id
  @GeneratedValue(generator = "gen_student", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_student", sequenceName = "seq_student", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "student_course",
      joinColumns = @JoinColumn(
          name = "student_id",
          referencedColumnName = "id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "course_id",
          referencedColumnName = "id"
      )
  )
  private Set<Course> courses = new HashSet<>();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void addCourse(Course course) {
    this.courses.add(course);
    course.getStudents().add(this);
  }
}
