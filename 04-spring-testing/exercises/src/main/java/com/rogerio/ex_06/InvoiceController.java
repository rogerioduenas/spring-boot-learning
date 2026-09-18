package com.rogerio.ex_06;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

  private final Clock clock;

  public InvoiceController(Clock clock) {
    this.clock = clock;
  }

  @GetMapping("/{number}")
  public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable String number) {
    InvoiceResponse response = new InvoiceResponse(
        number,
        new BigDecimal("1500.50"),
        LocalDateTime.now(clock)
    );
    return ResponseEntity.ok(response);
  }
}
