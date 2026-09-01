package com.rogerio.mockito_bean;

import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MockitoBeanTests {

  @Autowired
  private ApplicationContext applicationContext;

  @MockitoBean
  private UserPrincipal userPrincipal;

  @Test
  public void contextLoads() {
    assertNotNull(applicationContext);

    UserPrincipal context = applicationContext.getBean(UserPrincipal.class);

    assertNotNull(context);
  }
}
