package com.rogerio.ex_08;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class CurrencyConverterClient {

  private final RestTemplate restTemplate;

  public CurrencyConverterClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ConversionResult convertCurrency(String from, String to, BigDecimal amount) {
    String url = String.format("https://api.exchangerate.com/v1/convert?from=%s&to=%s&amount=%s", from, to, amount);
    return restTemplate.getForObject(url, ConversionResult.class);
  }
}
