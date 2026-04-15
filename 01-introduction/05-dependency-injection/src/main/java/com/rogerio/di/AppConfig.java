package com.rogerio.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Engine engine() {
    return new Engine(2.0);
  }

  @Bean
  public Car car() {
    return new Car(engine());
  }

  @Bean
  public Motorcycle motorcycle() {
    Motorcycle motorcycle = new Motorcycle();
    motorcycle.setEngine(engine());
    return motorcycle;
  }
}
