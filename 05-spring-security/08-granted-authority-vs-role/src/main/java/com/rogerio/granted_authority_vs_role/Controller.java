package com.rogerio.granted_authority_vs_role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/api/admin/dashboard")
  public ResponseEntity<String> adminDashboard() {
    return ResponseEntity.ok("Access to the admin dashboard granted");
  }

  @GetMapping("/api/reports/read")
  public ResponseEntity<String> readReport() {
    return ResponseEntity.ok("Access to the report granted due to having READ_PRIVILEGE");
  }

  @GetMapping("/api/manager/reports")
  public ResponseEntity<String> managerReports() {
    return ResponseEntity.ok("Executive report released to the MANAGER!");
  }
}
