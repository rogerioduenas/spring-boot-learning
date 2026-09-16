package com.rogerio.retrieve_user_information;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final IAuthenticationFacade authenticationFacade;

  public OrderService(IAuthenticationFacade authenticationFacade) {
    this.authenticationFacade = authenticationFacade;
  }

  public String createOrder() {
    String username = authenticationFacade.getAuthentication().getName();
    return "Order successfully created for the user: " + username;
  }
}
