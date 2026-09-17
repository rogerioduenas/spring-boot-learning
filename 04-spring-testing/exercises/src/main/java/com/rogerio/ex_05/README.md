### 🚀 EXERCISE 05 — Global Exception Handling (@ControllerAdvice) and 404 Not Found

**🎯 Focus & Techniques to Practice**

- Testing the Web layer by simulating exceptions thrown by the Service (`given(...).willThrow(...)`).
- Ensuring that the `@ControllerAdvice` is loaded within the scope of the `@WebMvcTest`.
- Mapping the domain exception `UserNotFoundException` to the standardized HTTP `404 Not Found` response structure.

**📄 Exercise Description and Business Rules**

When attempting to retrieve a non-existent user via `GET /api/v1/users/{id}`, the service layer throws the domain exception `UserNotFoundException`. The `GlobalExceptionHandler` must intercept this exception and return a user-friendly response.

- **Rule 1:** Intercept the `UserNotFoundException` via `@ExceptionHandler`.
- **Rule 2:** Return the HTTP status `404 Not Found`.
- **Rule 3:** The JSON body must contain the standardized structure: `timestamp`, `status` (404), `error` ("Resource Not Found"), and `message`.

**💻 Production Code**

```java
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
```

```java
public record UserResponse(Long id, String name, String email) {}
```

```java
public record StandardError(
    Instant timestamp,
    Integer status,
    String error,
    String message,
    String path
) {}
```

```java
public interface UserService {
  UserResponse findById(Long id);
}
```

```java
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
    UserResponse response = userService.findById(id);
    return ResponseEntity.ok(response);
  }
}
```

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<StandardError> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
    StandardError error = new StandardError(
        Instant.now(),
        HttpStatus.NOT_FOUND.value(),
        "Resource Not Found",
        ex.getMessage(),
        request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
```