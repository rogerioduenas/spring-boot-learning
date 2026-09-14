package com.rogerio.security_filter_chain_basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResourceController.class)
@Import(SecurityConfig.class)
@DisplayName("Security Integration Tests (SecurityFilterChain)")
class SecurityConfigTest {

  @Autowired
  private MockMvc mvc;

  @Nested
  @DisplayName("Anonymous User Scenarios (Unauthenticated)")
  class AnonymousUserTests {

    @Test
    @DisplayName("Should return 200 OK when accessing public login endpoint")
    @WithAnonymousUser
    void givenAnonymousUser_whenAccessLogin_thenReturns200Ok() throws Exception {
      mvc.perform(get("/login"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 401 Unauthorized when accessing protected endpoint without authentication")
    @WithAnonymousUser
    void givenAnonymousUser_whenAccessProtectedEndpoint_thenReturns401Unauthorized() throws Exception {
      mvc.perform(get("/all"))
          .andExpect(status().isUnauthorized());
    }
  }

  @Nested
  @DisplayName("USER Role Scenarios")
  class UserRoleTests {

    @Test
    @DisplayName("Should return 200 OK when accessing dedicated user endpoint")
    @WithMockUser(roles = "USER")
    void givenUserRole_whenAccessUserEndpoint_thenReturns200Ok() throws Exception {
      mvc.perform(get("/user"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 200 OK when accessing general authenticated endpoint")
    @WithMockUser(roles = "USER")
    void givenUserRole_whenAccessGeneralEndpoint_thenReturns200Ok() throws Exception {
      mvc.perform(get("/all"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 403 Forbidden when accessing admin endpoint")
    @WithMockUser(roles = "USER")
    void givenUserRole_whenAccessAdminEndpoint_thenReturns403Forbidden() throws Exception {
      mvc.perform(get("/admin"))
          .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Should return 403 Forbidden when executing delete operation")
    @WithMockUser(roles = "USER")
    void givenUserRole_whenExecuteDelete_thenReturns403Forbidden() throws Exception {
      mvc.perform(delete("/delete"))
          .andExpect(status().isForbidden());
    }
  }

  @Nested
  @DisplayName("ADMIN Role Scenarios")
  class AdminRoleTests {

    @Test
    @DisplayName("Should return 200 OK when accessing user endpoint")
    @WithMockUser(roles = "ADMIN")
    void givenAdminRole_whenAccessUserEndpoint_thenReturns200Ok() throws Exception {
      mvc.perform(get("/user"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 200 OK when accessing protected admin endpoint")
    @WithMockUser(roles = "ADMIN")
    void givenAdminRole_whenAccessAdminEndpoint_thenReturns200Ok() throws Exception {
      mvc.perform(get("/admin"))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return 200 OK when executing delete operation")
    @WithMockUser(roles = "ADMIN")
    void givenAdminRole_whenExecuteDelete_thenReturns200Ok() throws Exception {
      mvc.perform(delete("/delete").content("{}"))
          .andExpect(status().isOk());
    }
  }
}
