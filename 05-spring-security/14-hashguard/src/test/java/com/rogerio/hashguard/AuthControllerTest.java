package com.rogerio.hashguard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private UserRepository userRepository;

  @MockitoBean
  private PasswordEncoder passwordEncoder;

  @Test
  @DisplayName("Should register a user successfully and return 200 OK")
  void register_ShouldReturn200_WhenUserIsRegistered() throws Exception {
    AuthRequest request = new AuthRequest("rogerio", "123456");
    String encodedPassword = "$2a$10$encodedPasswordHashExample";

    when(passwordEncoder.encode("123456")).thenReturn(encodedPassword);
    when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

    mockMvc.perform(post("/auth/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().string("User registered successfully! Hash in bank: " + encodedPassword));
  }

  @Test
  @DisplayName("Should login successfully when credentials are correct")
  void login_ShouldReturn200_WhenCredentialsAreValid() throws Exception {
    AuthRequest request = new AuthRequest("rogerio", "123456");
    User savedUser = new User("rogerio", "$2a$10$encodedPasswordHashExample");

    when(userRepository.findByUsername("rogerio")).thenReturn(Optional.of(savedUser));
    when(passwordEncoder.matches("123456", savedUser.getPassword())).thenReturn(true);

    mockMvc.perform(post("/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().string("Login successful"));
  }

  @Test
  @DisplayName("Should return 401 Unauthorized when user is not found")
  void login_ShouldReturn401_WhenUserNotFound() throws Exception {
    AuthRequest request = new AuthRequest("userInexistente", "123456");

    when(userRepository.findByUsername("userInexistente")).thenReturn(Optional.empty());

    mockMvc.perform(post("/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isUnauthorized())
        .andExpect(content().string("Username not found"));
  }

  @Test
  @DisplayName("Should return 401 Unauthorized when password is incorrect")
  void login_ShouldReturn401_WhenPasswordIsIncorrect() throws Exception {
    AuthRequest request = new AuthRequest("rogerio", "senhaErrada");
    User savedUser = new User("rogerio", "$2a$10$encodedPasswordHashExample");

    when(userRepository.findByUsername("rogerio")).thenReturn(Optional.of(savedUser));
    when(passwordEncoder.matches("PasswordWrong", savedUser.getPassword())).thenReturn(false);

    mockMvc.perform(post("/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isUnauthorized())
        .andExpect(content().string("Password not match"));
  }
}