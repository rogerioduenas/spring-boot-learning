package com.rogerio.granular_rbac_many_to_many.Repository;

import com.rogerio.granular_rbac_many_to_many.model.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AbstractUser, Long> {
  Optional<AbstractUser> findByEmail(String email);
}
