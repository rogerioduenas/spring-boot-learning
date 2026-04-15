package com.rogerio.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  @Bean
  public ObjectMapper myFormatter(){
    return new ObjectMapper();
  }
}
