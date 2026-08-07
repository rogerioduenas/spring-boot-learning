package com.rogerio.library_checkout_flow.controller;

import com.rogerio.library_checkout_flow.dto.BorrowRequestDTO;
import com.rogerio.library_checkout_flow.dto.ReceiptDTO;
import com.rogerio.library_checkout_flow.service.BorrowingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class BorrowingController {

  private final BorrowingService borrowingService;

  public BorrowingController(BorrowingService borrowingService) {
    this.borrowingService = borrowingService;
  }

  @PostMapping("/checkout")
  public ResponseEntity<ReceiptDTO> checkout(@Valid @RequestBody BorrowRequestDTO requestDTO) {
    ReceiptDTO dto = borrowingService.borrowBook(requestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
}
