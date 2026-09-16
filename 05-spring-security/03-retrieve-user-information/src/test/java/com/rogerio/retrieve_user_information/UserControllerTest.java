package com.rogerio.retrieve_user_information;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Should return logged-in username when user is authenticated")
  @WithMockUser(username = "rogerio.backend")
  void shouldReturnLoggedInUsernameWhenAuthenticated() throws Exception {
    // GIVEN
    String expectedUsername = "rogerio.backend";
    String expectedResponseBody = "Logged-in user: " + expectedUsername;

    // WHEN
    MvcResult result = mockMvc.perform(get("/users/me"))
        .andExpect(status().isOk())
        .andReturn();

    // THEN
    String actualResponseBody = result.getResponse().getContentAsString();
    assertThat(actualResponseBody)
        .isNotNull()
        .isEqualTo(expectedResponseBody);
  }

  @Test
  @DisplayName("Should return 401 Unauthorized when user is not authenticated")
  void shouldReturn401WhenNotAuthenticated() throws Exception {
    MvcResult result = mockMvc.perform(get("/users/me"))
        .andExpect(status().isUnauthorized())
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(401);
  }
}