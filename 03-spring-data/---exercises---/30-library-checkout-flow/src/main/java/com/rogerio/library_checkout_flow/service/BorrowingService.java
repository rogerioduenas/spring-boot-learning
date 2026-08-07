package com.rogerio.library_checkout_flow.service;

import com.rogerio.library_checkout_flow.dto.BorrowRequestDTO;
import com.rogerio.library_checkout_flow.dto.ReceiptDTO;
import com.rogerio.library_checkout_flow.exception.ResourceNotFoundException;
import com.rogerio.library_checkout_flow.mapper.BorrowingRecordMapper;
import com.rogerio.library_checkout_flow.model.Book;
import com.rogerio.library_checkout_flow.model.Borrower;
import com.rogerio.library_checkout_flow.model.BorrowingRecord;
import com.rogerio.library_checkout_flow.repository.BookRepository;
import com.rogerio.library_checkout_flow.repository.BorrowerRepository;
import com.rogerio.library_checkout_flow.repository.BorrowingRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BorrowingService {

  private final BorrowerRepository borrowerRepository;
  private final BookRepository bookRepository;
  private final BorrowingRecordRepository borrowingRecordRepository;
  private final BorrowingRecordMapper borrowingRecordMapper;

  public BorrowingService(
      BorrowerRepository borrowerRepository,
      BookRepository bookRepository,
      BorrowingRecordRepository borrowingRecordRepository,
      BorrowingRecordMapper borrowingRecordMapper) {
    this.borrowerRepository = borrowerRepository;
    this.bookRepository = bookRepository;
    this.borrowingRecordRepository = borrowingRecordRepository;
    this.borrowingRecordMapper = borrowingRecordMapper;
  }

  @Transactional(rollbackFor = Exception.class)
  public ReceiptDTO borrowBook(BorrowRequestDTO dto) {
    Borrower borrower = getBorrowerById(dto.borrowerId());
    Book book = getBookById(dto.bookId());

    book.decrementAvailableCopies();

    BorrowingRecord borrowingRecord = borrowingRecordRepository.save(new BorrowingRecord(book, borrower, LocalDate.now()));

    return borrowingRecordMapper.toDTO(borrowingRecord);
  }

  private Borrower getBorrowerById(Long id) {
    return borrowerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Borrower not found"));
  }

  private Book getBookById(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
  }
}
