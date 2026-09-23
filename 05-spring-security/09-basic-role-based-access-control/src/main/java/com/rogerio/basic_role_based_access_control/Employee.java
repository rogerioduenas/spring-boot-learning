package com.rogerio.basic_role_based_access_control;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "tb_employees")
public class Employee extends AbstractUser {

  public Employee() {
  }

  public Employee(String email, String password, Set<Role> roles) {
    setEmail(email);
    setPassword(password);
    setRoles(roles);
  }
}
