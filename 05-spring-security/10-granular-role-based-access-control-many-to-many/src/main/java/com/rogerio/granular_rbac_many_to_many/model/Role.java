package com.rogerio.granular_rbac_many_to_many.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "tb_roles_privileges",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id")
  )
  private Set<Privilege> privileges = new HashSet<>();

  public Role() {}

  public Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Set<Privilege> getPrivileges() {
    return privileges;
  }
}
