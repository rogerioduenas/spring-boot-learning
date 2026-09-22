package com.rogerio.granted_authority_vs_role;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationTest {

  @Autowired
  private MockMvc mockMvc;

  @Nested
  @DisplayName("Scenarios for the Standard User")
  class CommonUserTests {

    @Test
    @WithMockUser(username = "user", authorities = {"READ_PRIVILEGE"})
    @DisplayName("User: must allow access to /api/reports/read (200)")
    void commonUser_ShouldAllow_ReadReport() throws Exception {
      mockMvc.perform(get("/api/reports/read"))
          .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"READ_PRIVILEGE"})
    @DisplayName("User: must deny access to /api/admin/dashboard (403)")
    void commonUser_ShouldDeny_AdminDashboard() throws Exception {
      mockMvc.perform(get("/api/admin/dashboard"))
          .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"READ_PRIVILEGE"})
    @DisplayName("User: must deny access to /api/manager/reports (403)")
    void commonUser_ShouldDeny_ManagerReports() throws Exception {
      mockMvc.perform(get("/api/manager/reports"))
          .andExpect(status().isForbidden());
    }
  }

  @Nested
  @DisplayName("Scenarios for Administrator User")
  class AdminUserTests {

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @DisplayName("Admin: must allow access to /api/admin/dashboard (200)")
    void adminUser_ShouldAllow_AdminDashboard() throws Exception {
      mockMvc.perform(get("/api/admin/dashboard"))
          .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @DisplayName("Admin: must deny access to /api/reports/read (403)")
    void adminUser_ShouldDeny_ReadReport() throws Exception {
      mockMvc.perform(get("/api/reports/read"))
          .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @DisplayName("Admin: must deny access to /api/manager/reports (403)")
    void adminUser_ShouldDeny_ManagerReports() throws Exception {
      mockMvc.perform(get("/api/manager/reports"))
          .andExpect(status().isForbidden());
    }
  }

  @Nested
  @DisplayName("Scenarios for Manager User")
  class ManagerUserTests {

    @Test
    @WithMockUser(username = "manager", authorities = {"ROLE_MANAGER", "READ_PRIVILEGE", "WRITE_PRIVILEGE"})
    @DisplayName("Manager: must allow access to /api/reports/read (200)")
    void managerUser_ShouldAllow_ReadReport() throws Exception {
      mockMvc.perform(get("/api/reports/read"))
          .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "manager", authorities = {"ROLE_MANAGER", "READ_PRIVILEGE", "WRITE_PRIVILEGE"})
    @DisplayName("Manager: must allow access to /api/manager/reports (200)")
    void managerUser_ShouldAllow_ManagerReports() throws Exception {
      mockMvc.perform(get("/api/manager/reports"))
          .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "manager", authorities = {"ROLE_MANAGER", "READ_PRIVILEGE", "WRITE_PRIVILEGE"})
    @DisplayName("Manager: must deny access to /api/admin/dashboard (403)")
    void managerUser_ShouldDeny_AdminDashboard() throws Exception {
      mockMvc.perform(get("/api/admin/dashboard"))
          .andExpect(status().isForbidden());
    }
  }
}
