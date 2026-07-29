package com.rogerio.unique_constraints.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_employee", uniqueConstraints =
@UniqueConstraint(name = "employee_tax_id", columnNames = {"tax_id"}))
public class Employee {

  @Id
  @GeneratedValue(generator = "gen_employee", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen_employee", sequenceName = "seq_employee", allocationSize = 1)
  private Long id;

  private String firstName;
  private String lastName;
  private String taxId;

  public Employee() {
  }

  public Employee(String firstName, String lastName, String taxId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.taxId = taxId;
  }
}
