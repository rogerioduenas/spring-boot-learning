package com.rogerio.authentication_provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
@Import({SecurityConfig.class, CustomAuthenticationProvider.class})
class CustomAuthenticationProviderTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldReturn401WhenNoCredentialsProvided() throws Exception {
    mockMvc.perform(get("/login"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  void shouldReturn200WhenCredentialsAreValid() throws Exception {
    mockMvc.perform(get("/login")
            .with(httpBasic("admin", "123")))
        .andExpect(status().isOk())
        .andExpect(content().string("Access Allowed"));
  }

  @Test
  void shouldReturn401WhenCredentialsAreInvalid() throws Exception {
    mockMvc.perform(get("/login")
            .with(httpBasic("admin", "WRONG_PASSWORD")))
        .andExpect(status().isUnauthorized());
  }
}
