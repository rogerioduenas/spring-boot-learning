package com.rogerio.granular_rbac_many_to_many.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_privileges")
public class Privilege {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToMany(mappedBy = "privileges")
  private Set<Role> roles = new HashSet<>();

  public Privilege() {
  }

  public Privilege(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
