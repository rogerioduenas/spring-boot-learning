package com.rogerio.library_checkout_flow.dto;

import java.time.LocalDate;

public record ReceiptDTO(Long id, String bookTitle, String borrowerName, LocalDate checkoutDate) {
}
