package com.rogerio.header_auth.controller;

import com.rogerio.header_auth.dto.SuccessResponseDTO;
import com.rogerio.header_auth.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @GetMapping("/auth")
  public ResponseEntity<SuccessResponseDTO> auth(@RequestHeader("Admin-Token") String token) {
    adminService.authAdmin(token);
    SuccessResponseDTO dto = new SuccessResponseDTO("Access granted. Welcome to the classified area.");
    return ResponseEntity.ok().body(dto);
  }
}
