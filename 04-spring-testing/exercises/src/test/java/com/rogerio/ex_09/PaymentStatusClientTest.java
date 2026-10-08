package com.rogerio.ex_09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(MockitoExtension.class)
class PaymentStatusClientTest {

  private PaymentStatusClient client;
  private MockRestServiceServer server;

  @BeforeEach
  void setUp() {
    RestTemplate restTemplate = new RestTemplate();
    server = MockRestServiceServer.createServer(restTemplate);
    client = new PaymentStatusClient(restTemplate);
  }

  @Test
  @DisplayName("Should throw ExternalServiceUnavailableException when the external API returns a 500 error")
  void givenRemoteServiceError500_whenGetStatus_thenThrowExternalServiceUnavailableException() {
    // Given
    String paymentId = "PAY-123";
    server.expect(requestTo("https://api.payments.com/v1/status/" + paymentId))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withServerError());

    // When & Then
    assertThatThrownBy(() -> client.getStatus(paymentId))
        .isInstanceOf(ExternalServiceUnavailableException.class)
        .hasMessage("Payment service unavailable");

    server.verify();
  }

  @Test
  @DisplayName("Should throw PaymentNotFoundException when the external API returns a 404 error")
  void givenRemoteServiceError404_whenGetStatus_thenThrowPaymentNotFoundException() {
    // Given
    String paymentId = "PAY-INVALID";
    server.expect(requestTo("https://api.payments.com/v1/status/" + paymentId))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withStatus(HttpStatus.NOT_FOUND));

    // When & Then
    assertThatThrownBy(() -> client.getStatus(paymentId))
        .isInstanceOf(PaymentNotFoundException.class)
        .hasMessage("Payment not found with id: " + paymentId);

    server.verify();
  }
}
