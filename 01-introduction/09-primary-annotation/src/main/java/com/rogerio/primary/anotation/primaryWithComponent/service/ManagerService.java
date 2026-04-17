package com.rogerio.primary.anotation.primaryWithComponent.service;

import com.rogerio.primary.anotation.primaryWithComponent.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

  @Autowired
  private Manager manager;

  public Manager getManager() {
    return manager;
  }
}
