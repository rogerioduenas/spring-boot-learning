package com.rogerio.di;

public class Motorcycle {
  private String model;
  private  Engine engine;

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Motorcycle{" +
        "model='" + model + '\'' +
        ", engine=" + engine +
        '}';
  }
}
