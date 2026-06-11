package com.rogerio.payment_critical_logger.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public void intentionalError(){
    throw new IllegalStateException("intentional error");
  }
}
