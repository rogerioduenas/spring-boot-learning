### 🚀 EXERCISE 06 — Advanced JSON Serialization/Deserialization (Jackson)

**🎯 Focus & Techniques to Practice**

- JSON formatting and contract using Jackson with Spring Boot (`@WebMvcTest` or `@JsonTest`).
- Ensuring an ISO-8601 contract (`@JsonFormat`) for temporal types (`LocalDateTime`).
- Preserving the precision and scale of monetary fields (`BigDecimal`) in the returned JSON.

**📄 Exercise Statement and Business Rules**

The `GET /api/v1/invoices/{number}` endpoint returns billing data mapped to the `InvoiceResponse` DTO.

- **Rule 1 (`createdAt`):** Must be serialized strictly using the ISO-8601 format: `"yyyy-MM-dd'T'HH:mm:ss"`.
- **Rule 2 (`totalAmount`):** Must be serialized as a decimal numeric value while preserving two decimal places (e.g., `1500.50`).

**💻 Production Code**

```java
public record InvoiceResponse(
    String invoiceNumber,

    BigDecimal totalAmount,

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt
) {}
```

```java
@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

  private final Clock clock;

  public InvoiceController(Clock clock) {
    this.clock = clock;
  }

  @GetMapping("/{number}")
  public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable String number) {
    InvoiceResponse response = new InvoiceResponse(
        number,
        new BigDecimal("1500.50"),
        LocalDateTime.now(clock)
    );
    return ResponseEntity.ok(response);
  }
}
```