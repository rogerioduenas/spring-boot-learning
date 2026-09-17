package com.rogerio.ex_05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UserService userService;

  @Test
  @DisplayName("Should return 404 Not Found with StandardError.class when user ID doesn't exist")
  void givenNonExistingUserId_whenFindById_thenReturn404NotFoundWithStandardError() throws Exception {
    // Given
    given(userService.findById(1L))
        .willThrow(new UserNotFoundException("User not found"));

    // When
    ResultActions result = mockMvc.perform(get("/api/v1/users/1"));

    // Then
    result
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.timestamp").exists())
        .andExpect(jsonPath("$.status").value(404))
        .andExpect(jsonPath("$.error").value("Resource Not Found"))
        .andExpect(jsonPath("$.message").value("User not found"))
        .andExpect(jsonPath("$.path").value("/api/v1/users/1"));
  }

  @Test
  @DisplayName("Should return 200 OK with UserResponse when user exists")
  void givenExistingUserId_whenFindById_thenReturn200OKAndUserResponse() throws Exception {
    // Given
    given(userService.findById(1L)).willReturn(new UserResponse(1L, "Mike", "mike@mike.com"));

    // When
    ResultActions result = mockMvc.perform(get("/api/v1/users/1"));

    // Then
    result
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Mike"))
        .andExpect(jsonPath("$.email").value("mike@mike.com"));
  }
}
