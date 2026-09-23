package com.rogerio.basic_role_based_access_control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {
    userRepository.deleteAll();

    Employee user = new Employee("user@email.com", passwordEncoder.encode("123456"), Set.of(Role.ROLE_USER));
    Employee admin = new Employee("admin@email.com", passwordEncoder.encode("123456"), Set.of(Role.ROLE_ADMIN));

    userRepository.saveAll(Set.of(user, admin));
  }

  @Nested
  @DisplayName("Public Endpoint Tests")
  class PublicEndpoints {

    @Test
    @DisplayName("Must allow public access without authentication")
    void shouldAllowPublicAccessWithoutAuth() throws Exception {
      mockMvc.perform(get("/api/public/hello"))
          .andExpect(status().isOk());
    }
  }

  @Nested
  @DisplayName("Endpoint Tests /api/user")
  class UserEndpoint {

    @Test
    @DisplayName("Should deny access when unauthenticated")
    void shouldBlockAnonymous() throws Exception {
      mockMvc.perform(get("/api/user/hello"))
          .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Must allow access for user with ROLE_USER")
    void shouldAllowUserRole() throws Exception {
      mockMvc.perform(get("/api/user/hello"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Must authenticate with valid bank credentials via HTTP Basic")
    void shouldAuthenticateWithDatabaseCredentials() throws Exception {
      mockMvc.perform(get("/api/user/hello")
              .with(httpBasic("user@email.com", "123456")))
          .andExpect(status().isOk());
    }
  }

  @Nested
  @DisplayName("Endpoint Tests /api/admin")
  class AdminEndpoint {

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 403 Forbidden for user without ROLE_ADMIN")
    void shouldDenyUserRole() throws Exception {
      mockMvc.perform(get("/api/admin/hello"))
          .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("Must allow access for user with ROLE_ADMIN")
    void shouldAllowAdminRole() throws Exception {
      mockMvc.perform(get("/api/admin/hello"))
          .andExpect(status().isOk());
    }
  }
}
