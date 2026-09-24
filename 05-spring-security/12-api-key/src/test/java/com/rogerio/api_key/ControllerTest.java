package com.rogerio.api_key;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(Controller.class)
@Import(SecurityConfig.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Should allow access to the public route without the need for a header")
  void shouldAllowAccessToPublicEndpointWithoutApiKey() throws Exception {
    mockMvc.perform(get("/public/ping"))
        .andExpect(status().isOk())
        .andExpect(content().string("Public access allowed"));
  }

  @Test
  @DisplayName("Should deny access to protected route when API Key is missing")
  void shouldDenyAccessToProtectedEndpointWhenApiKeyIsMissing() throws Exception {
    mockMvc.perform(get("/api/data"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  @DisplayName("Should deny access to protected route when API Key is invalid")
  void shouldDenyAccessToProtectedEndpointWhenApiKeyIsInvalid() throws Exception {
    mockMvc.perform(get("/api/data")
            .header("X-API-KEY", "wrong-key"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  @DisplayName("Should allow access to the protected endpoint when the API Key is valid")
  void shouldAllowAccessToProtectedEndpointWhenApiKeyIsValid() throws Exception {
    mockMvc.perform(get("/api/data")
            .header("X-API-KEY", "my-secret-key"))
        .andExpect(status().isOk())
        .andExpect(content().string("Private access granted with valid API Key"));
  }
}