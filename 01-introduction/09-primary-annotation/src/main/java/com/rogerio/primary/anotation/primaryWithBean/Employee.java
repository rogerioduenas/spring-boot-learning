package com.rogerio.primary.anotation.primaryWithBean;

public class Employee {

  private final String name;

  public Employee(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
