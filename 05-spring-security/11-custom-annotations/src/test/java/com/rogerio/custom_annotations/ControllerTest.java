package com.rogerio.custom_annotations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(authorities = "USER_READ")
  void shouldAllowReadWhenUserHasAuthority() throws Exception {
    mockMvc.perform(get("/users"))
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(roles = "USER")
  void shouldDenyDeleteWhenUserIsNotAdmin() throws Exception {
    mockMvc.perform(delete("/users/1"))
        .andExpect(status().isForbidden());
  }
}
