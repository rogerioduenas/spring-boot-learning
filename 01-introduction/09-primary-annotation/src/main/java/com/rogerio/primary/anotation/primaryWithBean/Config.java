package com.rogerio.primary.anotation.primaryWithBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

  @Bean
  public Employee JohnEmployee() {
    return new Employee("John");
  }

  @Bean
  @Primary
  public Employee TonyEmployee() {
    return new Employee("Primary employee");
  }
}
