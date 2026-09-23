package com.rogerio.basic_role_based_access_control;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AbstractUser, Long> {
  Optional<AbstractUser> findByEmail(String email);
}
