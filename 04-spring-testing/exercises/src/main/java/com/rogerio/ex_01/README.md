### 🚀 EXERCISE 01 — Custom JPQL Query with Paginated Search and Sorting

**🎯 Focus & Techniques to Practice**

- `@DataJpaTest` for loading the data context with an in-memory H2 database.
- Validation of JPQL queries (`@Query`) integrated with `Pageable`, `PageRequest`, and `Sort`.
- Complete assertions of the `Page` contract: content size, total pages, total elements, and sorting.

**📄 Exercise Description and Business Rules**

The `CustomerRepository` must query customers filtered by `CustomerStatus`, applying pagination and dynamic sorting via `Pageable`.

- **Rule 1:** The query must strictly filter by the specified status.
- **Rule 2:** The number of items returned by `getContent()` must respect the `pageSize` defined by the `Pageable`.
- **Rule 3:** The dynamic sorting defined by `Sort` must be correctly applied to the returned results.

**💻 Production Code**

Java

``` Java
public enum CustomerStatus {
  ACTIVE, INACTIVE, BLOCKED
}
```

``` Java
@Entity
@Table(name = "tb_customers")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;

  @Enumerated(EnumType.STRING)
  private CustomerStatus status;

  public CustomerEntity() {}

  public CustomerEntity(String name, String email, CustomerStatus status) {
    this.name = name;
    this.email = email;
    this.status = status;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public CustomerStatus getStatus() { return status; }
}
```

``` Java
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

  @Query("SELECT c FROM CustomerEntity c WHERE c.status = :status")
  Page<CustomerEntity> findByStatus(@Param("status") CustomerStatus status, Pageable pageable);
}
```
