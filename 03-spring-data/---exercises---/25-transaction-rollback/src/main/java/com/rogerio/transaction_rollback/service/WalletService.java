package com.rogerio.transaction_rollback.service;

import com.rogerio.transaction_rollback.dto.TransferRequestDTO;
import com.rogerio.transaction_rollback.exception.TransferFailedException;
import com.rogerio.transaction_rollback.model.Wallet;
import com.rogerio.transaction_rollback.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletService {

  private final WalletRepository walletRepository;

  public WalletService(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Transactional(rollbackFor = Exception.class)
  public void transferMoney(TransferRequestDTO dto) throws TransferFailedException {
    Wallet fromWallet = findWalletById(dto.fromWalletId());
    Wallet toWallet = findWalletById(dto.toWalletId());
    BigDecimal amount = dto.amount();

    fromWallet.setBalance(fromWallet.getBalance().subtract(amount));
    toWallet.setBalance(toWallet.getBalance().add(amount));

    throw new TransferFailedException("Network Timeout.");
  }

  private Wallet findWalletById(Long walletId) {
    return walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Wallet with id " + walletId + " not found"));
  }
}
