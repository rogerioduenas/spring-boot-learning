package com.rogerio.enum_converter.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class AccountStatusConverter implements AttributeConverter<AccountStatus, String> {

  @Override
  public String convertToDatabaseColumn(AccountStatus accountStatus) {
    if (accountStatus == null) {
      return null;
    }
    return accountStatus.getValue();
  }

  @Override
  public AccountStatus convertToEntityAttribute(String accountStatus) {
    if (accountStatus == null) {
      return null;
    }
    return Stream.of(AccountStatus.values())
        .filter(as -> as.getValue().equals(accountStatus))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown status code: " + accountStatus));
  }
}
