package com.rogerio.circular.dependencies.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircDepA {

  private CircDepB circDepB;

  @Autowired
  public CircDepA(@Lazy CircDepB circDepB) {
    this.circDepB = circDepB;
  }
}
