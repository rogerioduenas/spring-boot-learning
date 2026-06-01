package com.rogerio.user_registration.service;

import com.rogerio.user_registration.dto.AccountRequestDTO;
import com.rogerio.user_registration.exception.InvalidAgeException;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  public void createAccount(AccountRequestDTO accountRequestDTO) {
    if (accountRequestDTO.age() < 18) {
      throw new InvalidAgeException("Invalid age, must be at least 18 years old.");
    }
    System.out.printf("%s's user account was successfully completed.", accountRequestDTO.name());
  }
}
