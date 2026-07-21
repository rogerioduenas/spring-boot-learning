package com.rogerio.one_to_one_profile.model;

import jakarta.persistence.*;

@Entity
public class EmployeeProfile {

  @Id
  @GeneratedValue(generator = "gen_emp-p", strategy = GenerationType.AUTO)
  @SequenceGenerator(name = "gen_emp-p", sequenceName = "seq_emp-p", allocationSize = 1)
  private Long id;

  private String address;
  private String phoneNumber;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id", unique = true, nullable = false)
  private Employee employee;

  public EmployeeProfile() {
  }

  public EmployeeProfile(String address, String phoneNumber, Employee employee) {
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.employee = employee;
  }
}
