package com.rogerio.spring_bean_primary.service.impl;

import com.rogerio.spring_bean_primary.service.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationServiceImpl implements NotificationService {

  @Override
  public void sendNotification(String message) {
  System.out.printf("[SMS] Sending message '%s'%n", message);
  }
}
