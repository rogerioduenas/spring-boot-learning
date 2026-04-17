package com.rogerio.circular.dependencies.model;

import org.springframework.stereotype.Component;

@Component
public class CircDepB {

  private CircDepA circDepA;

  public CircDepB(CircDepA circDepA) {
    this.circDepA = circDepA;
  }
}
