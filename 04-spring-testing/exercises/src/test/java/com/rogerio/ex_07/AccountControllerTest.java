package com.rogerio.ex_07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@Import(GlobalExceptionHandler.class)
class AccountControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private AccountService accountService;

  @Test
  @DisplayName("Should return 422 Unprocessable Entity with BusinessErrorResponse when balance is insufficient")
  void givenInsufficientBalance_whenWithdraw_thenReturn422UnprocessableEntity()
      throws Exception {
    // Given
    WithdrawRequest request = new WithdrawRequest(1L, new BigDecimal("500.00"));

    willThrow(new InsufficientBalanceException("Insufficient funds"))
        .given(accountService)
        .withdraw(any(WithdrawRequest.class));

    // When
    ResultActions result = mockMvc.perform(post("/api/v1/accounts/withdraw")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)));

    // Then
    result
        .andExpect(status().isUnprocessableContent())
        .andExpect(jsonPath("$.code").value("BUSINESS_RULE_VIOLATION"))
        .andExpect(jsonPath("$.message").value("Insufficient funds"));
  }
}