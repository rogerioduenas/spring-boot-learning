package com.rogerio.dynamic_injection.service;

import com.rogerio.dynamic_injection.dto.ShippingCalculationResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

  private final Double shippingFee;

  public ShippingService(@Value("${shipping.fixed-fee}") Double shippingFee) {
    this.shippingFee = shippingFee;
  }

  public ShippingCalculationResponseDTO calc(Double productPrice) {
    Double total = shippingFee + productPrice;
    return new ShippingCalculationResponseDTO(productPrice, shippingFee, total);
  }
}
