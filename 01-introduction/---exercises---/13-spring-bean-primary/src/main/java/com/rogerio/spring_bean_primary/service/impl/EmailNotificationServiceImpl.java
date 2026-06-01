package com.rogerio.spring_bean_primary.service.impl;

import com.rogerio.spring_bean_primary.service.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotificationServiceImpl implements NotificationService {

  @Override
  public void sendNotification(String message) {
  System.out.printf("[EMAIL] Sending message '%s'%n", message);
  }
}
