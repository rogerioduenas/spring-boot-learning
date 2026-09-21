package com.rogerio.exception_handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Should return 401 Unauthorized and the formatted ProblemDetail when not authenticated")
  void shouldReturn401AndProblemDetailWhenUnauthenticated() throws Exception {
    mockMvc.perform(get("/api/protected")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized())
        .andExpect(jsonPath("$.status").value(401))
        .andExpect(jsonPath("$.title").value("Authentication Failed"))
        .andExpect(jsonPath("$.detail").exists());
  }

  @Test
  @WithMockUser
  @DisplayName("Should return 200 OK when the user is authenticated")
  void shouldReturn200WhenAuthenticated() throws Exception {
    mockMvc.perform(get("/api/protected"))
        .andExpect(status().isOk())
        .andExpect(content().string("Access to the protected resource is permitted"));
  }
}
