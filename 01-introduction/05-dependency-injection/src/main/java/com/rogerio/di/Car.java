package com.rogerio.di;

public class Car {
  private String model;
  private  Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Car{" +
        "model='" + model + '\'' +
        ", engine=" + engine +
        '}';
  }
}
