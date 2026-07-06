package com.rogerio.unidirectional_bidirectional_association.bidirectional.manyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Developer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "developers")
  private Set<Project> projects = new HashSet<>();

  public Developer(String name) {
    this.name = name;
  }
}
