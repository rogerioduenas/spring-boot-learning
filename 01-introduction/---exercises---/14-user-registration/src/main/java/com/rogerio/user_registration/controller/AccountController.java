package com.rogerio.user_registration.controller;

import com.rogerio.user_registration.dto.AccountRequestDTO;
import com.rogerio.user_registration.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody AccountRequestDTO accountRequestDTO) {
    accountService.createAccount(accountRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
