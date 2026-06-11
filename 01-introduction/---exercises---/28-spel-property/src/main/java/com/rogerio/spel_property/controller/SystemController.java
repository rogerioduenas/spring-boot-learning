package com.rogerio.spel_property.controller;

import com.rogerio.spel_property.dto.AdminEmailResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {

  private final List<String> adminEmails;

  public SystemController(@Value("#{'${app.admin-emails}'.split(',')}")List<String> adminEmails) {
    this.adminEmails = adminEmails;
  }

  @GetMapping("/admins")
  public ResponseEntity<List<AdminEmailResponseDTO>> getAdmins() {
    List<AdminEmailResponseDTO> dto = adminEmails.stream()
        .map(AdminEmailResponseDTO::new)
        .toList();

    return ResponseEntity.ok(dto);
  }
}
