package com.rogerio.course_enrollment.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

  @Id
  @GeneratedValue(generator = "gen_course", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_course", sequenceName = "seq_course", allocationSize = 1)
  private Long id;

  private String title;

  @ManyToMany(mappedBy = "courses")
  private Set<Student> students = new HashSet<>();

  public Course() {
  }

  public Course(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public Set<Student> getStudents() {
    return students;
  }
}
