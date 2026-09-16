package com.rogerio.retrieve_user_information;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class OrderServiceTest {

  @Autowired
  private OrderService orderService;

  @Test
  @DisplayName("Should create order successfully when user is authenticated in Spring Security context")
  @WithMockUser(username = "rogerio.backend")
  void shouldCreateOrderSuccessfullyWhenUserIsAuthenticated() {
    // GIVEN
    String expectedUsername = "rogerio.backend";
    String expectedResult = "Order successfully created for the user: " + expectedUsername;

    // WHEN
    String actualResult = orderService.createOrder();

    // THEN
    assertThat(actualResult)
        .isNotNull()
        .isEqualTo(expectedResult);
  }

  @Test
  @DisplayName("Should throw NullPointerException when no authentication is present in context")
  void shouldThrowExceptionWhenNoAuthenticationPresent() {
      assertThatThrownBy(() -> orderService.createOrder())
        .isInstanceOf(NullPointerException.class);
  }
}
