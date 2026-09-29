### 🚀 EXERCISE 07 — Business Rule Violation in the Service with a Custom Exception

**🎯 Focus & Techniques to Practice**

- Stubbing domain/business exceptions with Mockito in a Web scope (`@WebMvcTest`).
- Centralized handling of business rule exceptions with an HTTP `422 Unprocessable Entity` response.
- Mapping an error contract containing a standardized business error code.

**📄 Exercise Description and Business Rules**

When attempting to withdraw money from a bank account with insufficient available balance, the `AccountService` throws the `InsufficientBalanceException`.

- **Rule 1:** If the balance is insufficient, the service throws `InsufficientBalanceException`.
- **Rule 2:** The `GlobalExceptionHandler` must catch this exception and respond with HTTP `422 Unprocessable Entity`.
- **Rule 3:** The JSON body must contain the error code `"BUSINESS_RULE_VIOLATION"` and the detailed message.

**💻 Production Code**

```java
public class InsufficientBalanceException extends RuntimeException {
  public InsufficientBalanceException(String message) {
    super(message);
  }
}
```

```java
public record WithdrawRequest(Long accountId, BigDecimal amount) {}
```

```java
public record BusinessErrorResponse(String code, String message) {}
```

```java
public interface AccountService {
  void withdraw(WithdrawRequest request);
}
```

```java
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/withdraw")
  public ResponseEntity<Void> withdraw(@RequestBody WithdrawRequest request) {
    accountService.withdraw(request);
    return ResponseEntity.ok().build();
  }
}
```

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InsufficientBalanceException.class)
  public ResponseEntity<BusinessErrorResponse> handleInsufficientBalance(InsufficientBalanceException ex) {
    BusinessErrorResponse error = new BusinessErrorResponse("BUSINESS_RULE_VIOLATION", ex.getMessage());
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
  }
}
```