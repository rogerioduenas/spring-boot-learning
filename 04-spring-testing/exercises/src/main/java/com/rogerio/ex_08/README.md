### 🚀 EXERCISE 08 — Successful External API Consumption with MockRestServiceServer

🎯 **Focus & Techniques to Practice**

- `@ExtendWith(MockitoExtension.class)` for an isolated, high-performance unit test.
- Manual instantiation of `MockRestServiceServer` using `MockRestServiceServer.createServer(restTemplate)`.
- Validation of the HTTP request contract (URI, Query Parameters, and HTTP Method).

📄 **Statement and Business Rules**

The `CurrencyConverterClient` performs currency conversion by consuming an external REST API (`[https://api.exchangerate.com/v1/convert](https://api.exchangerate.com/v1/convert)`).

- **Rule 1:** The GET request must contain the required query parameters: `from`, `to`, and `amount`.
- **Rule 2:** The response from the external API must be correctly deserialized into the `ConversionResult` DTO.

💻 **Production Code**

```java
public record ConversionResult(
    boolean success,
    BigDecimal convertedAmount,
    BigDecimal rate
) {}
```

```java
@Component
public class CurrencyConverterClient {

  private final RestTemplate restTemplate;

  public CurrencyConverterClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ConversionResult convertCurrency(String from, String to, BigDecimal amount) {
    String url = String.format("https://api.exchangerate.com/v1/convert?from=%s&to=%s&amount=%s", from, to, amount);
    return restTemplate.getForObject(url, ConversionResult.class);
  }
}
```