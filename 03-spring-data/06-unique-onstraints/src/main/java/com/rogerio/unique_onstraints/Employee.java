package com.rogerio.unique_onstraints;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(name = "UniqueNumberAndStatus", columnNames = {"personNumber", "isActive"}),
    @UniqueConstraint(name = "UniqueSecurityAndDepartment", columnNames = {"securityNumber", "departmentCode"})
})
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
  @SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence", allocationSize = 1)
  private Long id;

  private String name;

  private Integer personNumber;
  private Boolean isActive;

  private String securityNumber;
  private String departmentCode;
}
