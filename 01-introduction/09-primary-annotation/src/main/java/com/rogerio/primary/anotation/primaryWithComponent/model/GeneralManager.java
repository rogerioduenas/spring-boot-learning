package com.rogerio.primary.anotation.primaryWithComponent.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GeneralManager implements Manager {

  @Override
  public String getManagerName() {
    return "General manager";
  }

  @Override
  public String toString() {
    return "General manager";
  }
}
