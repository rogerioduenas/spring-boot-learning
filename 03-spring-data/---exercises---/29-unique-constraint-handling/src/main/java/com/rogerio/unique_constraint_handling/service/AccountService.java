package com.rogerio.unique_constraint_handling.service;

import com.rogerio.unique_constraint_handling.dto.AccountRequestDTO;
import com.rogerio.unique_constraint_handling.mapper.AccountMapper;
import com.rogerio.unique_constraint_handling.model.Account;
import com.rogerio.unique_constraint_handling.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;

  public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
    this.accountRepository = accountRepository;
    this.accountMapper = accountMapper;
  }

  public void save(AccountRequestDTO dto){
    Account account = accountMapper.toEntity(dto);
    accountRepository.save(account);
  }
}
