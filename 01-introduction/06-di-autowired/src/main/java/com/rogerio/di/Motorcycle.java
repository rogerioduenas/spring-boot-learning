package com.rogerio.di;

import org.springframework.stereotype.Component;

@Component
public class Motorcycle {
  private  Engine engine;

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Motorcycle{" +
        "engine=" + engine +
        '}';
  }
}
