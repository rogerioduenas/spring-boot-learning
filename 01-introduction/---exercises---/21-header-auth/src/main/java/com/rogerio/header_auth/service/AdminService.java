package com.rogerio.header_auth.service;

import com.rogerio.header_auth.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  @Value("${app.security.token}")
  private String token;

  public void authAdmin(String receivedToken) {
    if (!token.equals(receivedToken)) {
      throw new UnauthorizedException("Access denied");
    }
  }
}
