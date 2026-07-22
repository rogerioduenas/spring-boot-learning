# 🏋️ Exercise 05 — The Orphan Removal Challenge

## 📝 Description

In our order system, if a customer decides to remove a product from the cart before checkout, removing that **Item** from the **Order** collection in Java should automatically delete the corresponding row from the database.

## ⚙️ Technical Objectives

- Master the `orphanRemoval = true` configuration in a `@OneToMany` collection
- Understand how JPA monitors collection modifications to automatically issue `DELETE` statements

## 📂 Required Structure

### Entities

**Order** (`id`, `orderNumber`, `items`)
```java
@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
```

**Item** (`id`, `productName`, `price`, `order`)

## 🎯 Repositories and Services

### OrderService

```java
public void removeItemFromOrder(Long orderId, Long itemId)
```

## 📋 Business Rules

1. Retrieve the existing **Order** by its ID.
2. Find the target **Item** inside the order's collection using the provided `itemId`.
3. Remove the item from the collection (`order.getItems().remove(item)`).
4. Save the **Order** (or let the transaction commit flush the changes). The removed item should be automatically deleted from the database.

## 🧪 Test Case

**When:** `removeItemFromOrder(1L, 5L)` is called.

**Then:** The SQL logs should show a `DELETE FROM order_items WHERE id = 5` statement, proving that disassociating the child from its parent triggered its physical deletion.