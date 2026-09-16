### 🚀 EXERCISE 04 — Input Payload Validation (@Valid / Bean Validation)

**🎯 Focus & Techniques to Practice**

- `@WebMvcTest(ProductController.class)` with `MockMvc`.
- Automatic Bean Validation interception in Spring MVC (`MethodArgumentNotValidException`).
- Ensuring controller-layer isolation by verifying no interactions with mocks (`thenHaveNoInteractions`).

**📄 Exercise Description and Business Rules**

The `POST /api/v1/products` endpoint must validate the `ProductRequest` payload before invoking the service layer.

- **Rule 1 (`name`):** Must not be null or blank (`@NotBlank`).
- **Rule 2 (`price`):** Must not be null and must be greater than zero (`@NotNull`, `@Positive`).
- **Rule 3 (`quantityInStock`):** Must not be null and must be greater than or equal to zero (`@NotNull`, `@PositiveOrZero`).
- **Rule 4:** If any attribute is invalid, the controller must reject the request and return `400 Bad Request` without calling the `ProductService`.

**💻 Production Code**

```java
public record ProductRequest(
    @NotBlank(message = "Name is required")
    String name,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    Double price,

    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity must be zero or positive")
    Integer quantityInStock
) {}
```

```java
public record ProductResponse(Long id, String name, Double price, Integer quantityInStock) {}
```

```java
public interface ProductService {
  ProductResponse createProduct(ProductRequest request);
}
```

```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
    ProductResponse response = productService.createProduct(request);
    return ResponseEntity.created(URI.create("/api/v1/products/" + response.id())).body(response);
  }
}
```