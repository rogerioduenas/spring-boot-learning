# 🏋️ Exercise 04 — Cascade Persist vs. Manual Save

## 📝 Description

You are building an order processing module. An `Order` contains multiple `OrderItems`. Saving each item individually using a loop in the Service layer is a bad practice. You need to configure cascading so that saving an order automatically persists all of its items in a single clean operation.

## ⚙️ Technical Objectives

- Practice using `CascadeType.PERSIST` on a `@OneToMany` collection.
- Write a clean Service layer method with only a single `save` operation.

## 📂 Required Structure

### Entities

**Order**
- `id`
- `orderNumber`
- `items`

```java
@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
```

**OrderItem**
- `id`
- `productName`
- `price`
- `order`

```java
@ManyToOne
@JoinColumn(name = "order_id")
```

## 🎯 Repositories and Services

### OrderService

```java
public Order createOrderWithItems(String orderNumber, List<OrderItem> items)
```

## 📋 Business Rules

- Create an `Order` instance.
- Associate each `OrderItem` in the list with the `Order` (bidirectional synchronization).
- Save only the `Order` entity using `OrderRepository.save(order)`.
- Verify that all `OrderItem` records are automatically persisted to the database due to the cascade configuration.

## 🧪 Test Case

**When:** Save an `Order` with 3 new items.

**Then:** The SQL console should display **1 INSERT** into the `orders` table and **3 INSERTs** into the `order_items` table, even though `OrderItemRepository` was never called or even injected.
