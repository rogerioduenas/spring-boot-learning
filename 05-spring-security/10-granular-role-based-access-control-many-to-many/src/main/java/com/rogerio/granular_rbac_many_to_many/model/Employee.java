package com.rogerio.granular_rbac_many_to_many.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_employees")
public class Employee extends AbstractUser {

  private String department;

  public Employee() {
  }

  public Employee(String email, String password, String department) {
    setEmail(email);
    setPassword(password);
    this.department = department;
  }
}
