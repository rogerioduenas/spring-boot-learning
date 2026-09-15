### 🚀 EXERCISE 03 — Context Synchronization and L1 Cache Cleanup (flush/clear)

**🎯 Focus & Techniques to Practice**

- Using `TestEntityManager.flush()` and `TestEntityManager.clear()` in `@DataJpaTest`.
- Understanding and controlling the Hibernate/JPA First-Level Cache (L1 Cache).
- Testing custom `@Modifying` queries to ensure the `UPDATE` is executed and the actual state is reloaded from H2.

**📄 Exercise Statement and Business Rules**

The `AccountRepository` contains a bulk update query using `@Modifying`. It is necessary to ensure that the change is reflected in the database and that the subsequent lookup reloads the entity from the database rather than from the L1 Cache.

- **Rule 1:** The `@Query` with `@Modifying` must update the customer's balance by ID.
- **Rule 2:** Executing `flush()` and `clear()` must force synchronization and clear the persistence context.
- **Rule 3:** The `findById` query after clearing the context must retrieve the updated entity from the database.

**💻 Production Code**

```java
@Entity
@Table(name = "tb_accounts")
public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String owner;
  private Double balance;

  public AccountEntity() {}

  public AccountEntity(String owner, Double balance) {
    this.owner = owner;
    this.balance = balance;
  }

  public Long getId() { return id; }
  public String getOwner() { return owner; }
  public Double getBalance() { return balance; }
  public void setBalance(Double balance) { this.balance = balance; }
}
```

```java
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  @Modifying
  @Query("UPDATE AccountEntity a SET a.balance = :balance WHERE a.id = :id")
  void updateBalance(@Param("id") Long id, @Param("balance") Double balance);
}
```
