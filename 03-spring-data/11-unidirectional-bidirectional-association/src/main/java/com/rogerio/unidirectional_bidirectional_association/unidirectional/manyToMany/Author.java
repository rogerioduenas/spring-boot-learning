package com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToMany;

import jakarta.persistence.*;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
  @SequenceGenerator(name = "id_gen", sequenceName = "seq_id", allocationSize = 1)
  private Long id;

  private String name;

  public Author(String name) {
    this.name = name;
  }
}
