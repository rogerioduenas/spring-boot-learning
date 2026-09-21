package com.rogerio.manual_authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldAuthenticateInCurrentRequestButNotPersistInNextRequest() throws Exception {
    LoginDTO loginDTO = new LoginDTO("admin", "123456");

    mockMvc.perform(post("/api/login-stateless")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loginDTO)))
        .andExpect(status().isOk())
        .andExpect(content().string("User admin successfully authenticated"));

    mockMvc.perform(get("/api/me"))
        .andExpect(status().isUnauthorized());
  }

  @Test
  void shouldAuthenticateAndPersistInHttpSessionAcrossRequests() throws Exception {
    LoginDTO loginDTO = new LoginDTO("admin", "123456");

    MockHttpSession session = (MockHttpSession) mockMvc.perform(post("/api/login-stateful")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(loginDTO)))
        .andExpect(status().isOk())
        .andExpect(content().string(("User admin successfully authenticated")))
        .andReturn()
        .getRequest()
        .getSession();

    assertThat(session).isNotNull();

    mockMvc.perform(get("/api/me")
            .session(session))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("admin")));
  }
}
