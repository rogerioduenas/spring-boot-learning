package com.rogerio.unique_constraint_handling.controller;

import com.rogerio.unique_constraint_handling.dto.AccountRequestDTO;
import com.rogerio.unique_constraint_handling.service.AccountService;
import jakarta.validation.Valid;
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
  public ResponseEntity<Void> save(@Valid @RequestBody AccountRequestDTO dto) {
    accountService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
