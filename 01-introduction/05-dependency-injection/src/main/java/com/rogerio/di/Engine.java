package com.rogerio.di;

public class Engine {
  private final Double power;

  public Engine(Double power) {
    this.power = power;
  }

  @Override
  public String toString() {
    return "Engine{" +
        "power=" + power +
        '}';
  }
}
