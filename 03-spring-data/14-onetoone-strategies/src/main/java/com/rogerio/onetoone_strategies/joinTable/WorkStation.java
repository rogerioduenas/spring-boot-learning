package com.rogerio.onetoone_strategies.joinTable;

import jakarta.persistence.*;

@Entity
@Table(name = "workstation")
public class WorkStation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "workStation")
  private Employee employee;

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
