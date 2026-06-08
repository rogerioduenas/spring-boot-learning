package com.rogerio.lazy_initialization.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {

  private final ServiceA serviceA;

  public ServiceB(ServiceA serviceA) {
    this.serviceA = serviceA;
  }

  public void executeB() {
    System.out.println("Hello inside Service B");
  }
}
