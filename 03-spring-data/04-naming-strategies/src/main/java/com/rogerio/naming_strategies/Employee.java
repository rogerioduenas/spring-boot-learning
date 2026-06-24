package com.rogerio.naming_strategies;

import jakarta.persistence.*;

@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {

  public static final String TABLE_NAME = "tb_employee";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long employeeId;
  private String firstName;
  private String lastName;
}
