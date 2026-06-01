package com.rogerio.spring_bean_primary.controller;

import com.rogerio.spring_bean_primary.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

  private final NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping
  public ResponseEntity<String> sendNotification(@RequestParam(value = "msg") String message) {
    notificationService.sendNotification(message);
    return ResponseEntity.ok("Notification processed");
  }
}
