package com.rogerio.custom_filter_chain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(Controller.class)
@Import({SecurityConfig.class, CustomFilter.class})
@DisplayName("Integration Test for CustomFilter and SecurityConfig")
class SecurityConfigIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  @DisplayName("Should pass through CustomFilter and return 200 OK")
  void givenLoginEndpoint_whenGet_thenReturns200Ok() throws Exception {
    mvc.perform(get("/login"))
        .andExpect(status().isOk());
  }
}
