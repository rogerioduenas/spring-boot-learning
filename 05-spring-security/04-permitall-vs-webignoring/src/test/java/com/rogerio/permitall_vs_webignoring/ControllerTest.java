package com.rogerio.permitall_vs_webignoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Should pass through security filter chain and return 200 OK for permitAll")
  void givenPermitAllUrl_whenGet_thenReturn200AndExecuteFilters() throws Exception {
    mockMvc.perform(get("/permit-all"))
        .andExpect(status().isOk())
        .andExpect(content().string("Passed through the security filters. (PermitAll)"));
  }

  @Test
  @DisplayName("Should completely bypass security filter chain and return 200 OK for web.ignoring")
  void givenWebIgnoringUrl_whenGet_thenReturn200BypassingFilters() throws Exception {
    mockMvc.perform(get("/web-ignore"))
        .andExpect(status().isOk())
        .andExpect(content().string("Completely ignored Spring Security. (WebIgnoring)"));
    // The test logs show that the security layer was bypassed.
  }
}
