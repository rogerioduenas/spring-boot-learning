package com.rogerio.unidirectional_bidirectional_association.bidirectional.manyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "project_developer",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name = "developer_id")
  )
  private Set<Developer> developers = new HashSet<>();

  public Set<Developer> getDevelopers() {
    return developers;
  }

  public Project(String name) {
    this.name = name;
  }
}
