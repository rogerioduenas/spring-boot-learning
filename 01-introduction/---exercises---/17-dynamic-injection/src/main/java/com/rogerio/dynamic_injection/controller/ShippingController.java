package com.rogerio.dynamic_injection.controller;

import com.rogerio.dynamic_injection.dto.ShippingCalculationResponseDTO;
import com.rogerio.dynamic_injection.service.ShippingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

  private final ShippingService shippingService;

  public ShippingController(ShippingService shippingService) {
    this.shippingService = shippingService;
  }

  @GetMapping("/calc")
  public ResponseEntity<ShippingCalculationResponseDTO> calculateShipping(@RequestParam Double productPrice) {
    ShippingCalculationResponseDTO responseDTO = shippingService.calc(productPrice);
    return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
  }
}
