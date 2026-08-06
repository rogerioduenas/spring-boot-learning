package com.rogerio.unique_constraint_handling.mapper;

import com.rogerio.unique_constraint_handling.dto.AccountRequestDTO;
import com.rogerio.unique_constraint_handling.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

  public Account toEntity(AccountRequestDTO dto){
    return new Account(
        dto.email(),
        dto.taxId()
    );
  }
}
