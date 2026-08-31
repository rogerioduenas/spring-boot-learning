package com.rogerio.junit_config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.class)
public class SpringJUnitConfigIntegrationTest {

  private final ApplicationContext applicationContext;

  public SpringJUnitConfigIntegrationTest(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Configuration
  static class Config {}

  @Test
  void given_appContext_When_injected_Then_itShouldNotBeNull(){
    assertNotNull(applicationContext);
  }
}
