package com.rogerio.onetoone_strategies.joinTable;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @OneToOne
  @JoinTable(name = "emp_workstation",
      joinColumns =
          {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
      inverseJoinColumns =
          {@JoinColumn(name = "workstation_id", referencedColumnName = "id")})
  private WorkStation workStation;

  public void setWorkStation(WorkStation workStation) {
    this.workStation = workStation;
  }
}
