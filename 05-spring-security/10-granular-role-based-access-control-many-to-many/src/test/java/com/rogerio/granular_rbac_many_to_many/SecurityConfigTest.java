package com.rogerio.granular_rbac_many_to_many;

import com.rogerio.granular_rbac_many_to_many.Repository.PrivilegeRepository;
import com.rogerio.granular_rbac_many_to_many.Repository.RoleRepository;
import com.rogerio.granular_rbac_many_to_many.Repository.UserRepository;
import com.rogerio.granular_rbac_many_to_many.model.Employee;
import com.rogerio.granular_rbac_many_to_many.model.Privilege;
import com.rogerio.granular_rbac_many_to_many.model.Role;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SecurityConfigTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilegeRepository privilegeRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {
    Privilege readPrivilege = privilegeRepository.save(new Privilege("USER_READ"));
    Privilege writePrivilege = privilegeRepository.save(new Privilege("USER_WRITE"));

    Role roleUser = new Role("ROLE_USER");
    roleUser.getPrivileges().add(readPrivilege);
    roleRepository.save(roleUser);

    Role roleAdmin = new Role("ROLE_ADMIN");
    roleAdmin.getPrivileges().addAll(Set.of(readPrivilege, writePrivilege));
    roleRepository.save(roleAdmin);
    String encodedPassword = passwordEncoder.encode("PASSWORD");

    Employee employee = new Employee("email@email.com", encodedPassword, "IT");
    employee.getRoles().add(roleAdmin);
    userRepository.save(employee);
  }

  @Nested
  @DisplayName("Granular Endpoint Tests: GET /api/users (Requires USER_READ)")
  class FindAllEndpoint {

    @Test
    @DisplayName("Should deny access to unauthenticated user (401)")
    void shouldBlockAnonymous() throws Exception {
      mockMvc.perform(get("/api/users"))
          .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(authorities = "USER_READ")
    @DisplayName("Must allow access when the user has USER_READ authority")
    void shouldAllowWhenHasUserReadAuthority() throws Exception {
      mockMvc.perform(get("/api/users"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$").isArray())
          .andExpect(jsonPath("$[0].email").value("email@email.com"));
    }

    @Test
    @WithMockUser(authorities = "SOME_OTHER_PRIVILEGE")
    @DisplayName("Should deny access (403) when the user lacks the USER_READ authority")
    void shouldDenyWhenLacksUserReadAuthority() throws Exception {
      mockMvc.perform(get("/api/users"))
          .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Should authenticate via HTTP Basic and load the USER_READ authority from the database")
    void shouldAuthenticateAndAllowViaHttpBasic() throws Exception {
      mockMvc.perform(get("/api/users")
              .with(httpBasic("email@email.com", "PASSWORD")))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].email").value("email@email.com"));
    }
  }

  @Nested
  @DisplayName("Endpoint Tests by Role: GET /api/users/{id} (Requires ROLE_ADMIN)")
  class FindByIdEndpoint {

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("Should return 403 Forbidden for a user who only has ROLE_USER")
    void shouldDenyUserRole() throws Exception {
      mockMvc.perform(get("/api/users/1"))
          .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("Should allow access for a user who has ROLE_ADMIN")
    void shouldAllowAdminRole() throws Exception {

      Long existingId = userRepository.findAll().get(0).getId();

      mockMvc.perform(get("/api/users/" + existingId))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.email").value("email@email.com"));
    }
  }
}