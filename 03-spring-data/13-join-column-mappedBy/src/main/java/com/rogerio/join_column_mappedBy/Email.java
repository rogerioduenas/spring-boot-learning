package com.rogerio.join_column_mappedBy;

import jakarta.persistence.*;

@Entity
public class Email {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String emailAddress;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public Email() {}

  public Email(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
