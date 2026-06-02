package com.rogerio.instance_control.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class TokenGenerator  {

  private final UUID uuid = UUID.randomUUID();

  public UUID getUuid() {
    return uuid;
  }
}
