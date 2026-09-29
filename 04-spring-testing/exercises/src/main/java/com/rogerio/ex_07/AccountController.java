package com.rogerio.ex_07;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/withdraw")
  public ResponseEntity<Void> withdraw(@RequestBody WithdrawRequest request) {
    accountService.withdraw(request);
    return ResponseEntity.ok().build();
  }
}
