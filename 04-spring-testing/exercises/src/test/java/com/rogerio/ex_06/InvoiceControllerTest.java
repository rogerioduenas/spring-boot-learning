package com.rogerio.ex_06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.web.servlet.MockMvc;

import java.time.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(InvoiceController.class)
class InvoiceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @TestConfiguration
  static class TestConfig {
    @Bean
    @Primary
    public Clock clock() {
      return Clock.fixed(
          Instant.parse("2026-09-05T14:30:00Z"),
          ZoneId.of("UTC")
      );
    }
  }

  @Test
  @DisplayName("Should return formatted JSON contract when fetching invoice")
  void givenInvoiceNumber_whenGetInvoice_thenReturnFormattedJsonContract() throws Exception {
    mockMvc.perform(get("/api/v1/invoices/INV-1020"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.invoiceNumber").value("INV-1020"))
        .andExpect(jsonPath("$.totalAmount").value(1500.50))
        .andExpect(jsonPath("$.createdAt").value("2026-09-05T14:30:00"));
  }
}