# 🏋️ Exercise 11 — Stock Validation with Service

## 📝 Description

Create a sales simulation system. The Controller receives the request, but a Service injected through constructor dependency injection is responsible for checking stock availability and updating the inventory. If there is not enough stock, a custom exception must be thrown.

---

# ⚙️ Technical Goals

- Practice Constructor Dependency Injection with a `@Service`.
- Practice using `@RestControllerAdvice` and `@ExceptionHandler` to handle a custom exception.

---

# 📂 Required Structure

## Entity
- `Product`
    - `id`
    - `name`
    - `quantity`

## Exception
- `InsufficientStockException`
    - Custom exception extending `RuntimeException`

## Classes
- `StockController`
- `StockService`

---

# 🎯 Routes and HTTP Verbs

## POST `/sales/{productId}?quantity=2`

Example:

```http
POST http://localhost:8080/sales/1?quantity=2
```

---

# 📋 Business Rules

- `StockService` must contain a static list of products (example: Smartphone with 5 units in stock).

- If the requested quantity is less than or equal to the available stock:
    - The Service decreases the stock quantity.
    - The Controller returns:
        - `200 OK`
        - The updated entity.

- If the requested quantity is greater than the available stock:
    - The Service must throw `InsufficientStockException`.

- Your `@RestControllerAdvice` must capture this exception and return:
    - `400 Bad Request`
    - Custom message:

```json
{
  "message": "Insufficient stock for the operation"
}
```

---

# 🧪 Postman Test Cases

## ✅ Success Case

### Request

```http
POST http://localhost:8080/sales/1?quantity=2
```

### Expected Response
- Status: `200 OK`

---

## ❌ Failure Case

### Request

```http
POST http://localhost:8080/sales/1?quantity=10
```

### Expected Response

- Status: `400 Bad Request`

```json
{
  "message": "Insufficient stock for the operation"
}
```