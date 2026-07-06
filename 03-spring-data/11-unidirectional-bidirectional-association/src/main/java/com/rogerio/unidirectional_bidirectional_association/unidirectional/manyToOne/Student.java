package com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToOne;

import jakarta.persistence.*;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "school_id")
  private School school;

  public Student(String name) {
    this.name = name;
  }

  public void setSchool(School school) {
    this.school = school;
  }
}
