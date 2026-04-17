package com.rogerio.primary.anotation.primaryWithComponent.model;

import org.springframework.stereotype.Component;

@Component
public class DepartmentManager implements Manager {

  @Override
  public String getManagerName() {
    return "Department manager";
  }

}
