package com.rogerio.library_checkout_flow.mapper;

import com.rogerio.library_checkout_flow.dto.ReceiptDTO;
import com.rogerio.library_checkout_flow.model.BorrowingRecord;
import org.springframework.stereotype.Component;

@Component
public class BorrowingRecordMapper {

  public ReceiptDTO toDTO(BorrowingRecord entity) {
    return new ReceiptDTO(
        entity.getId(),
        entity.getBook().getTitle(),
        entity.getBorrower().getName(),
        entity.getBorrowDate()
    );
  }
}
