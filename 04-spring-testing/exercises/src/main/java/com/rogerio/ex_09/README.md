### 🚀 EXERCISE 09 — Network Failure Handling and Remote 500 Error

🎯 **Focus & Techniques to Practice**

- `@ExtendWith(MockitoExtension.class)` for isolated and high-performance unit testing.
- Manual instantiation of `MockRestServiceServer` using `MockRestServiceServer.createServer(restTemplate)`.
- Simulation of remote HTTP failures (5xx and 4xx) using `withServerError()` and `withStatus(HttpStatus.NOT_FOUND)`.
- Validation of domain exception throwing and translation (`ExternalServiceUnavailableException` and `PaymentNotFoundException`).

📄 **Exercise Description & Business Rules**

The `PaymentStatusClient` retrieves the status of a payment from the external API (`[https://api.payments.com/v1/status/](https://api.payments.com/v1/status/){paymentId}`).

- **Rule 1:** 5xx family failures (Server Error) from the external API must be caught and converted into `ExternalServiceUnavailableException`.
- **Rule 2:** HTTP 404 Not Found responses from the external API must be converted into `PaymentNotFoundException`.

💻 **Production Code**

```java
public class ExternalServiceUnavailableException extends RuntimeException {
  public ExternalServiceUnavailableException(String message) { super(message); }
}
```

```java
public class PaymentNotFoundException extends RuntimeException {
  public PaymentNotFoundException(String message) { super(message); }
}
```

```java
public record PaymentStatusResponse(String paymentId, String status) {}
```

```java
@Component
public class PaymentStatusClient {

  private final RestTemplate restTemplate;

  public PaymentStatusClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PaymentStatusResponse getStatus(String paymentId) {
    String url = "https://api.payments.com/v1/status/" + paymentId;
    try {
      return restTemplate.getForObject(url, PaymentStatusResponse.class);
    } catch (HttpStatusCodeException ex) {
      if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
        throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
      }
      if (ex.getStatusCode().is5xxServerError()) {
        throw new ExternalServiceUnavailableException("Payment service unavailable");
      }
      throw ex;
    }
  }
}
``` 