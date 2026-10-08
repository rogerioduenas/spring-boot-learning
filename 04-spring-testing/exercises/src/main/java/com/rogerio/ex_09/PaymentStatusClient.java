package com.rogerio.ex_09;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentStatusClient {

  private final RestTemplate restTemplate;

  public PaymentStatusClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PaymentStatusResponse getStatus(String paymentId) {
    String url = "https://api.payments.com/v1/status/" + paymentId;
    try {
      return restTemplate.getForObject(url, PaymentStatusResponse.class);
    } catch (HttpStatusCodeException ex) {
      if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
        throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
      }
      if (ex.getStatusCode().is5xxServerError()) {
        throw new ExternalServiceUnavailableException("Payment service unavailable");
      }
      throw ex;
    }
  }
}
