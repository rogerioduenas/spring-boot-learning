package com.rogerio.instance_control.controller;

import com.rogerio.instance_control.dto.TokenCheckResponseDTO;
import com.rogerio.instance_control.model.TokenGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {

  private final TokenGenerator tokenGenerator1;
  private final TokenGenerator tokenGenerator2;

  public TokenController(TokenGenerator tokenGenerator1, TokenGenerator tokenGenerator2) {
    this.tokenGenerator1 = tokenGenerator1;
    this.tokenGenerator2 = tokenGenerator2;
  }

  @GetMapping("/check")
  public TokenCheckResponseDTO checkToken() {
    return new TokenCheckResponseDTO(tokenGenerator1.getUuid(), tokenGenerator2.getUuid());
  }
}
