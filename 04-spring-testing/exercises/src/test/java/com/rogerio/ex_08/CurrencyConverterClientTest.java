package com.rogerio.ex_08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(MockitoExtension.class)
class CurrencyConverterClientTest {

  private CurrencyConverterClient client;
  private MockRestServiceServer server;

  @BeforeEach
  void setUp() {
    RestTemplate restTemplate = new RestTemplate();
    server = MockRestServiceServer.createServer(restTemplate);
    client = new CurrencyConverterClient(restTemplate);
  }

  @Test
  @DisplayName("Should convert currency successfully when external API responds HTTP 200 OK")
  void givenValidConversionRequest_whenConvertCurrency_thenReturnConversionResult() {
    String expectedJsonBody = """ 
        { 
        "success": true, 
        "convertedAmount": 520.50, 
        "rate": 5.205 
        } 
        """;

    server.expect(requestTo(containsString("https://api.exchangerate.com/v1/convert")))
        .andExpect(requestTo(containsString("from=USD")))
        .andExpect(requestTo(containsString("to=BRL")))
        .andExpect(requestTo(containsString("amount=100.00")))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess(expectedJsonBody, MediaType.APPLICATION_JSON));

    ConversionResult result = client.convertCurrency("USD", "BRL", new BigDecimal("100.00"));

    assertThat(result).isNotNull();
    assertThat(result.success()).isTrue();
    assertThat(result.convertedAmount()).isEqualByComparingTo(new BigDecimal("520.50"));
    assertThat(result.rate()).isEqualByComparingTo(new BigDecimal("5.205"));

    server.verify();
  }
}