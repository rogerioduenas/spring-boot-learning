package com.rogerio.bean.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {

  // This is the standard; it uses the same object every time.
  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public Person personSingleton() {
    return new Person();
  }

  // Create a new one every time it's requested.
  @Bean
  @Scope("prototype")
  public Person personPrototype() {
    return new Person();
  }
}
