package com.rogerio.shared_primary_key.repository;

import com.rogerio.shared_primary_key.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
