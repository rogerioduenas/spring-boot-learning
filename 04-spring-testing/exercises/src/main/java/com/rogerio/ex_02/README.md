### 🚀 EXERCISE 02 — Database Uniqueness Constraint Validation

**🎯 Focus & Techniques to Practice**

- `@DataJpaTest` with relational constraint validation (`@Column(unique = true)`).
- Assertion of Spring/Hibernate integrity exceptions (`DataIntegrityViolationException`).
- `TestEntityManager` to persist and force the immediate submission of constraints to the database via `persistAndFlush`.

**📄 Exercise Description and Business Rules**

The `UserEntity` entity must ensure uniqueness for the `cpf` and `email` fields at the relational database level.

- **Rule 1:** Two users with the same CPF must not be allowed to be inserted.
- **Rule 2:** Two users with the same email must not be allowed to be inserted.
- **Rule 3:** Attempts to violate these constraints must throw `DataIntegrityViolationException`.

**💻 Production Code**

```java
@Entity
@Table(name = "tb_users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, nullable = false)
  private String cpf;

  public UserEntity() {}

  public UserEntity(String name, String email, String cpf) {
    this.name = name;
    this.email = email;
    this.cpf = cpf;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getCpf() { return cpf; }
}
```

```java
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
```