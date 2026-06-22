package com.rogerio.jpa_entities;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
  private String name;

  @Transient
  private Integer age;

  @Enumerated(EnumType.STRING)
  private Gender gender;
}
