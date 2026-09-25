package com.rogerio.jwt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JwtAuthenticationFlowIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @DisplayName("Full Flow: Generates the token at login and uses the Bearer Token to transit the application")
  void shouldAuthenticateAndAccessProtectedResourceWithJwt() throws Exception {

    String loginPayload = """
        { 
        "username": "user@email.com", 
        "password": "password123" 
        }
        """;

    MvcResult loginResult = mockMvc.perform(post("/api/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(loginPayload))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").exists())
        .andReturn();

    String responseBody = loginResult.getResponse().getContentAsString();
    JsonNode jsonNode = objectMapper.readTree(responseBody);
    String jwtToken = jsonNode.get("token").asText();

    mockMvc.perform(get("/api/data")
            .header("Authorization", "Bearer " + jwtToken))
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Analysis/Blocking: Should block the user if the token is missing or invalid")
  void shouldBlockAccessWhenTokenIsInvalidOrMissing() throws Exception {

    mockMvc.perform(get("/api/data"))
        .andExpect(status().isForbidden());

    mockMvc.perform(get("/api/data")
            .header("Authorization", "Bearer token-invalid-123"))
        .andExpect(status().isForbidden());
  }
}