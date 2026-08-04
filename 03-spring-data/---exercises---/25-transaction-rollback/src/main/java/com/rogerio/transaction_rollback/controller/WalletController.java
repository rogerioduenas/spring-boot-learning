package com.rogerio.transaction_rollback.controller;

import com.rogerio.transaction_rollback.dto.TransferRequestDTO;
import com.rogerio.transaction_rollback.exception.TransferFailedException;
import com.rogerio.transaction_rollback.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  private final WalletService walletService;

  public WalletController(WalletService walletService) {
    this.walletService = walletService;
  }

  @PostMapping("/transfers")
  public ResponseEntity<Void> transferMoney(@Valid @RequestBody TransferRequestDTO dto) throws TransferFailedException {
    walletService.transferMoney(dto);
    return ResponseEntity.ok().build();
  }
}
